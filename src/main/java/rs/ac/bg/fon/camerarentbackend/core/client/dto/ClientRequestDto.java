package rs.ac.bg.fon.camerarentbackend.core.client.dto;

import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;

public record ClientRequestDto(
        String name,
        String surname,
        String email,
        String password,
        String phoneNumber,
        Long cityId,
        Long clientTypeId
) {}
