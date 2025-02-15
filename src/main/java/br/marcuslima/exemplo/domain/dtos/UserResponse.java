package br.marcuslima.exemplo.domain.dtos;

import br.marcuslima.exemplo.domain.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "UserResponse", description = "User response object")
public class UserResponse {

    @Schema(description = "User id", example = "67b0925c5d72d414f6de14dd")
    private String id;

    @Schema(description = "User name", example = "John Doe")
    private String name;

    @Schema(description = "User email", example = "doe@john.com")
    private String email;

    @Schema(description = "User role", example = "ADMIN")
    private String role;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}
