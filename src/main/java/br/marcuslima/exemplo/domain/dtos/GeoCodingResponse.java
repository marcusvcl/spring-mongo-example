package br.marcuslima.exemplo.domain.dtos;

import lombok.Data;

@Data
public class GeoCodingResponse {
    private String display_name;
    private double lat;
    private double lon;
    private Address address;

    @Data
    public static class Address {
        private String country;
        private String city;
    }
}
