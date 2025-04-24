package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.model.Role;
import barnyard.pawmetrics.mapper.AccountMapper;
import barnyard.pawmetrics.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

//    public Account getByUsername(String username) {
//        return repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//    }

//    public Account getCurrentUser() {
//        return getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//    }
//
//
//    public boolean login(LoginDTO loginDTO) {
//        if (repository.existsByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())) {
//
//            return true;
//        }
//        return false;
//    }
//
//    public Account edit(Account user) {
//        Account currentUser = getCurrentUser();
//        currentUser.setEmail(user.getEmail());
//        currentUser.setUsername(user.getUsername());
//        currentUser.setPassword(user.getPassword());
//        currentUser.setPhoto(user.getPhoto());
//        return repository.save(currentUser);
//    }

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
}