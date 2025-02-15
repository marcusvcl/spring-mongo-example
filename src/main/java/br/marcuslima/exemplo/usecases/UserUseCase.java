package br.marcuslima.exemplo.usecases;

import java.util.List;

import br.marcuslima.exemplo.domain.dtos.UserRequest;
import br.marcuslima.exemplo.domain.dtos.UserResponse;

public interface UserUseCase {

    /**
     * Retrieves a list of users.
     *
     * @return a list of UserResponse objects representing the users.
     */
    List<UserResponse> listUsers();

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the unique identifier of the user to be retrieved
     * @return a UserResponse object containing the user's details
     */
    UserResponse getUser(String id);

    /**
     * Creates a new user based on the provided user request.
     *
     * @param request the user request containing the details of the user to be
     *                created
     * @return a response containing the details of the created user
     */
    UserResponse createUser(UserRequest request);

    /**
     * Updates an existing user based on the provided user request.
     *
     * @param id      the unique identifier of the user to be updated
     * @param request the user request containing the details of the user to be
     *                updated
     * @return a response containing the details of the updated user
     */
    UserResponse updateUser(String id, UserRequest request);

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the unique identifier of the user to be deleted
     */
    void deleteUser(String id);

}
