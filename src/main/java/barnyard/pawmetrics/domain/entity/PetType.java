package barnyard.pawmetrics.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String petTypeName;
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petType")
    private List<Breed> breeds = new ArrayList<>();
}
