package br.marcuslima.exemplo.usecases.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.marcuslima.exemplo.domain.dtos.GeoCodingCoordinates;
import br.marcuslima.exemplo.domain.dtos.GeoCodingResponse;
import br.marcuslima.exemplo.usecases.GeoCodingUseCase;
import br.marcuslima.exemplo.webclients.GeoCodingClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeoCodingService implements GeoCodingUseCase {

    private final GeoCodingClient geocodingClient;

    public String getAddressFromCoordinates(double lat, double lon) {
        GeoCodingResponse response = geocodingClient.reverseGeocode(lat, lon, "json");
        return response.getDisplay_name();
    }

    public GeoCodingCoordinates getCoordinatesFromAddress(String address) {
        List<GeoCodingResponse> results = geocodingClient.searchAddress(address, "json");
        if (results.isEmpty())
            throw new RuntimeException("Endereço não encontrado");
        return new GeoCodingCoordinates(results.get(0).getLat(), results.get(0).getLon());
    }

}
