package br.marcuslima.exemplo.domain.dtos;

import br.marcuslima.exemplo.domain.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "UserRequest", description = "User request object")
public class UserRequest {

    @Schema(description = "User name", example = "John Doe")
    @NotBlank
    private String name;

    @Schema(description = "User email", example = "doe@jhon.com")
    @NotBlank
    private String email;

    @Schema(description = "User password", example = "123456")
    @NotBlank
    private String password;

    @Schema(description = "User role", example = "ADMIN")
    @NotBlank
    private String role;

    public User toModel() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

}
