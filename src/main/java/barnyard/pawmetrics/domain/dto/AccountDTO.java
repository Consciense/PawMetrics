package barnyard.pawmetrics.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {
    @NotNull
    @NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private String email;
    private String photo;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String username;
}