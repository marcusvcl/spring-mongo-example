package br.marcuslima.exemplo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.marcuslima.exemplo.domain.models.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

    @Query("{ 'coordinates.latitude' : ?0, 'coordinates.longitude' : ?1 }")
    Location findByCoordinates(Double latitude, Double longitude);
}
