package rs.ac.bg.fon.camerarentbackend.core.employee.dto;

import rs.ac.bg.fon.camerarentbackend.core.account.dto.AccountRequestDto;

public record EmployeeRequestDto(
        String name,
        String surname,
        AccountRequestDto account
) {}
