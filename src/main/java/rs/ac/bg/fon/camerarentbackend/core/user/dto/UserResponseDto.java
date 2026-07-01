package rs.ac.bg.fon.camerarentbackend.core.user.dto;

public record UserResponseDto(
        Long id,
        String name,
        String surname,
        String email
) {}
