package barnyard.pawmetrics.domain.entity;

import barnyard.pawmetrics.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String photo;

    @Column(unique = true, nullable = false)
    private String username;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private ArrayList<Pet> pets;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private Set<Role> authorities;
}
