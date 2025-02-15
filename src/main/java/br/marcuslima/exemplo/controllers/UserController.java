package br.marcuslima.exemplo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.marcuslima.exemplo.domain.dtos.UserRequest;
import br.marcuslima.exemplo.domain.dtos.UserResponse;
import br.marcuslima.exemplo.usecases.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping()
    @Operation(summary = "List users", description = "List all users")
    public List<UserResponse> listUsers() {
        return userUseCase.listUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user", description = "Get user by id")
    public UserResponse getUser(String id) {
        return userUseCase.getUser(id);
    }

    @PostMapping()
    @Operation(summary = "Create user", description = "Create a new user")
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userUseCase.createUser(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", description = "Update user by id")
    public UserResponse updateUser(String id, @RequestBody UserRequest request) {
        return userUseCase.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", description = "Delete user by id")
    public void deleteUser(String id) {
        userUseCase.deleteUser(id);
    }

}
