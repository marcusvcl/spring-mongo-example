package br.marcuslima.exemplo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.marcuslima.exemplo.domain.models.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

} 