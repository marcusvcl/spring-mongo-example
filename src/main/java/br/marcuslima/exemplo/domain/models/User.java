package br.marcuslima.exemplo.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.marcuslima.exemplo.domain.dtos.UserRequest;
import br.marcuslima.exemplo.utils.Coalesce;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;

    public void updateFrom(UserRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("request is required");
        }

        this.name = Coalesce.of(request.getName(), this.name);
        this.email = Coalesce.of(request.getEmail(), this.email);
        this.password = Coalesce.of(request.getPassword(), this.password);
        this.role = Coalesce.of(request.getRole(), this.role);
    }

}
