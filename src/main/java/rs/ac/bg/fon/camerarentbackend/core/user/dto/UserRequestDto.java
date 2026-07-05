package rs.ac.bg.fon.camerarentbackend.core.user.dto;

import rs.ac.bg.fon.camerarentbackend.core.account.dto.AccountRequestDto;

public record UserRequestDto(
        String name,
        String surname,
        AccountRequestDto account
) {}
