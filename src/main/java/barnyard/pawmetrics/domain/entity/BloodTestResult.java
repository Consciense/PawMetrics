package barnyard.pawmetrics.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class BloodTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(nullable = false)
    private Double erythrocytes;

    @Column(nullable = false)
    private Double hemoglobin;

    @Column(nullable = false)
    private Double leukocytes;

    @Column(nullable = false)
    private Double neutrophils;

    @Column(nullable = false)
    private Double lymphocytes;

    @Column(nullable = false)
    private Double monocytes;

    @Column(nullable = false)
    private Double eosinophils;

    @Column(nullable = false)
    private LocalDate date;
}
