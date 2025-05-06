package barnyard.pawmetrics.domain.dto;

import barnyard.pawmetrics.domain.entity.Breed;
import barnyard.pawmetrics.domain.entity.PetType;
import barnyard.pawmetrics.domain.enums.PetGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetDTO {
    @NotNull
    @NotBlank
    private String name;
    private double weight;
    private int age;
    private PetGender gender;
    @NotNull
    @NotBlank
    private PetType type;
    @NotNull
    @NotBlank
    private Breed breed;
    private String image;
}
