package br.marcuslima.exemplo.usecases.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.marcuslima.exemplo.domain.dtos.GeoCodingCoordinates;
import br.marcuslima.exemplo.domain.dtos.GeoCodingResponse;
import br.marcuslima.exemplo.domain.models.Location;
import br.marcuslima.exemplo.repositories.LocationRepository;
import br.marcuslima.exemplo.usecases.GeoCodingUseCase;
import br.marcuslima.exemplo.webclients.GeoCodingClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeoCodingService implements GeoCodingUseCase {

    private final GeoCodingClient geocodingClient;
    private final LocationRepository locationRepository;

    public String getAddressFromCoordinates(double lat, double lon) {
        Location location = locationRepository.findByCoordinates(lat, lon);
        if (location != null)
            return location.getAddress().toString();

        GeoCodingResponse response = geocodingClient.reverseGeocode(lat, lon, "json");
        if (response == null)
            throw new RuntimeException("Endereço não encontrado");
        location = saveLocation(lat, lon, response);
        return location.getAddress().toString();
    }

    private Location saveLocation(double lat, double lon, GeoCodingResponse response) {
        Location location = Location.builder()
                .address(Location.Address.from(response.getDisplay_name()))
                .coordinates(Location.Coordinates.from(lat, lon))
                .build();
        return locationRepository.save(location);
    }

    public GeoCodingCoordinates getCoordinatesFromAddress(String address) {
        List<GeoCodingResponse> results = geocodingClient.searchAddress(address, "json");
        if (results.isEmpty())
            throw new RuntimeException("Endereço não encontrado");
        return new GeoCodingCoordinates(results.get(0).getLat(), results.get(0).getLon());
    }

}
