package barnyard.pawmetrics.domain.entity;

import barnyard.pawmetrics.domain.enums.PetGender;
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
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account owner;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private PetGender gender;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "breed_breed_id")
    private Breed breed;

    @OneToMany(mappedBy = "pet")
    private List<PetImage> image = new ArrayList<>();
}
