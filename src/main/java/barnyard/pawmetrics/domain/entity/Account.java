package barnyard.pawmetrics.domain.entity;

import barnyard.pawmetrics.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
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

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private Set<Role> authorities;
}
