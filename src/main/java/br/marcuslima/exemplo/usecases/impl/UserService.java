package br.marcuslima.exemplo.usecases.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.marcuslima.exemplo.domain.dtos.UserRequest;
import br.marcuslima.exemplo.domain.dtos.UserResponse;
import br.marcuslima.exemplo.domain.models.User;
import br.marcuslima.exemplo.repositories.UserRepository;
import br.marcuslima.exemplo.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> listUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }

    @Override
    public UserResponse getUser(String id) {
        return userRepository.findById(id)
                .map(UserResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = request.toModel();
        userRepository.save(user);
        return UserResponse.from(user);
    }

    @Override
    public UserResponse updateUser(String id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        user.updateFrom(request);
        userRepository.save(user);
        return UserResponse.from(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
