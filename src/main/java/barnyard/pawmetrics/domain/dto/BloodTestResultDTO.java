package barnyard.pawmetrics.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BloodTestResultDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private Long petId;
    @NotNull
    @NotBlank
    private Double erythrocytes;
    @NotNull
    @NotBlank
    private Double hemoglobin;
    @NotNull
    @NotBlank
    private Double leukocytes;
    @NotNull
    @NotBlank
    private Double neutrophils;
    @NotNull
    @NotBlank
    private Double lymphocytes;
    @NotNull
    @NotBlank
    private Double monocytes;
    @NotNull
    @NotBlank
    private Double eosinophils;
    @NotNull
    @NotEmpty
    @NotBlank
    private LocalDate date;
}
