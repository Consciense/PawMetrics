package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.AccountDTO;
import barnyard.pawmetrics.domain.dto.LoginDTO;
import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.domain.enums.Role;
import barnyard.pawmetrics.mapper.AccountMapper;
import barnyard.pawmetrics.repository.AccountRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void create(RegistrationDTO dto) {
        Account user = accountMapper.toEntity(dto);
        user.setAuthorities(Set.of(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public boolean login(@NotNull LoginDTO loginDTO) {
        if (repository.existsByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())) {
            loadUserByUsername(loginDTO.getUsername());
            return true;
        }
        return false;
    }

    public Account getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public Account getCurrentUser() {
        return getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void updatePassword(String newPassword) {
        Account currentUser = getCurrentUser();
        if (currentUser.getPassword().equals(passwordEncoder.encode(newPassword))) {
            throw new RuntimeException("New password matches the old password");
        }
        currentUser.setPassword(passwordEncoder.encode(newPassword));
        repository.save(currentUser);
    }

    public void update(AccountDTO dto) {
        repository.save(accountMapper.update(getCurrentUser(),dto));
    }

    public void updatePhoto(String photo) {
        Account currentUser = getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        currentUser.setPhoto(photo);
        repository.save(currentUser);
    }

    public void updatePets(Pet pet) {
        Account currentUser = getCurrentUser();
        ArrayList<Pet> pets = currentUser.getPets();
        pets.add(pet);
        currentUser.setPets(pets);
        repository.save(currentUser);
    }

    public void deletePet(String name){
        Account currentUser = getCurrentUser();
        ArrayList<Pet> pets = currentUser.getPets();
        pets.removeIf(pet -> pet.getName().equals(name));
        currentUser.setPets(pets);
        repository.save(currentUser);
    }

//    @Deprecated
//    public void setAdmin() {
//        Account user = getCurrentUser();
//        user.setAuthorities(Set.of(Role.ADMIN));
//        repository.save(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public boolean havePermissionToDelete(String username) {
        return repository.existsByUsername(username) && getCurrentUser().getUsername().equals(username);
    }
}