package barnyard.pawmetrics.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegistrationDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
}
