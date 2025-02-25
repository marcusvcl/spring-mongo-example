package br.marcuslima.exemplo.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "locations")
public class Location {

    @Id
    private String id;
    private Address address;
    private Coordinates coordinates;

    @Data
    @Builder
    public static class Address {
        private String street;
        private String number;
        private String neighborhood;
        private String city;
        private String state;
        private String country;
        private String postalCode;

        public static Address from(String s) {
            String[] parts = s.split(",");
            return Address.builder()
                    .street(parts[1])
                    .number(parts[0])
                    .neighborhood(parts[2])
                    .city(parts[3])
                    .state(parts[7])
                    .country(parts[10])
                    .postalCode(parts[9])
                    .build();
        }

        @Override
        public String toString() {
            return String.format("%s, %s - %s, %s, %s, %s, %s",
                    number, street, neighborhood, city, state, country, postalCode);
        }
    }

    @Data
    @Builder
    public static class Coordinates {
        private Double latitude;
        private Double longitude;

        public static Coordinates from(Double lat, Double lon) {
            return Coordinates.builder()
                    .latitude(lat)
                    .longitude(lon)
                    .build();
        }
    }
}
