package barnyard.pawmetrics.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long petId;
    private String image;
    private LocalDateTime timestamp;                        // проверить дату
    private String medTests;            // мб сделать билдер для класса анализа
}
