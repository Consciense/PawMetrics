package barnyard.pawmetrics.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breedId;
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;
    @Column(nullable = false)
    private String breedName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String defaultPicture;
}
