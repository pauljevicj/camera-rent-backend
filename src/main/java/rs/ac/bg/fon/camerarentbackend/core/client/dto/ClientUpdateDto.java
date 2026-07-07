package rs.ac.bg.fon.camerarentbackend.core.client.dto;

public record ClientUpdateDto(
        String name,
        String surname,
        String email,
        String phoneNumber,
        Long cityId,
        String clientType
) {
}
