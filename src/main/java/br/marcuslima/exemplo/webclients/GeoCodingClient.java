package br.marcuslima.exemplo.webclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.marcuslima.exemplo.domain.dtos.GeoCodingResponse;

@FeignClient(name = "geoCodingClient", url = "https://nominatim.openstreetmap.org")
public interface GeoCodingClient {

    @GetMapping("/search")
    List<GeoCodingResponse> searchAddress(
            @RequestParam("q") String address,
            @RequestParam("format") String format);

    @GetMapping("/reverse")
    GeoCodingResponse reverseGeocode(
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon,
            @RequestParam("format") String format);
}
