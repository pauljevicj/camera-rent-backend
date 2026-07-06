package rs.ac.bg.fon.camerarentbackend.core.client.dto;

import rs.ac.bg.fon.camerarentbackend.core.account.dto.AccountRequestDto;

public record ClientRequestDto(
        String name,
        String surname,
        AccountRequestDto account,
        String phoneNumber,
        Long cityId
) {}
