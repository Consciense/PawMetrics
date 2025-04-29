package barnyard.pawmetrics.domain.dto;

import barnyard.pawmetrics.domain.entity.Breed;
import barnyard.pawmetrics.domain.entity.PetImage;
import barnyard.pawmetrics.domain.entity.PetType;
import barnyard.pawmetrics.domain.enums.PetGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
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
    private ArrayList<PetImage> image;
}
