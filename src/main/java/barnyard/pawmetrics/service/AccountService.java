package barnyard.pawmetrics.service;

import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.model.Role;
import barnyard.pawmetrics.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void create(Account user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setAuthorities(Set.of(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public Account getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public Account getCurrentUser() {
        return getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Deprecated
    public void setAdmin() {
        Account user = getCurrentUser();
        user.setAuthorities(Set.of(Role.ADMIN));
        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}