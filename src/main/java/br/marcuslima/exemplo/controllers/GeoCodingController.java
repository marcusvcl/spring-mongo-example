package br.marcuslima.exemplo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.marcuslima.exemplo.domain.dtos.GeoCodingCoordinates;
import br.marcuslima.exemplo.usecases.GeoCodingUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/geocoding")
@RequiredArgsConstructor
public class GeoCodingController {

    private final GeoCodingUseCase geoCodingUseCase;

    @GetMapping("/address")
    public ResponseEntity<String> getAddress(
            @RequestParam double lat,
            @RequestParam double lng) {
        return ResponseEntity.ok(geoCodingUseCase.getAddressFromCoordinates(lat, lng));
    }

    @GetMapping("/coordinates")
    public ResponseEntity<GeoCodingCoordinates> getCoordinates(
            @RequestParam String address) {
        return ResponseEntity.ok(geoCodingUseCase.getCoordinatesFromAddress(address));
    }

}
