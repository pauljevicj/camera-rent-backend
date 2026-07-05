package rs.ac.bg.fon.camerarentbackend.core.employee.dto;

public record EmployeeResponseDto(
        Long id,
        String name,
        String surname,
        String email
) {}
