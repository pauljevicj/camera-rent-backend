package rs.ac.bg.fon.camerarentbackend.core.client.dto;

import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;

public record ClientResponseDto(
        Long id,
        String name,
        String surname,
        String email,
        String phoneNumber,
        CityResponseDto city,
        ClientTypeResponseDto clientType
) {}
