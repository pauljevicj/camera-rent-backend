package rs.ac.bg.fon.camerarentbackend.core.client.dto;

import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;

public record ClientResponseDto(
        Long id,
        String name,
        String surname,
        String email,
        String phoneNumber,
        CityResponseDto city,
        String clientType
) {}
