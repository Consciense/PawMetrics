package barnyard.pawmetrics.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String petType;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String defaultPicture;
}
