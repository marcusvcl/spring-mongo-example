package br.marcuslima.exemplo.usecases;

import br.marcuslima.exemplo.domain.dtos.GeoCodingCoordinates;

public interface GeoCodingUseCase {

    String getAddressFromCoordinates(double lat, double lon);

    GeoCodingCoordinates getCoordinatesFromAddress(String address);
}
