package rs.ac.bg.fon.camerarentbackend.core.user.dto;

public record UserRequestDto(
        String name,
        String surname,
        String email,
        String password
) {}
