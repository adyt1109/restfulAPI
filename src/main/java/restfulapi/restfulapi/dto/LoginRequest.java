package restfulapi.restfulapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Username must be fill!")
    private String username;

    @NotBlank(message = "Password must be fill!")
    private String password;
}
