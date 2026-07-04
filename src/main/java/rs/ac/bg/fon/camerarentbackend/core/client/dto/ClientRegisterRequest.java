package rs.ac.bg.fon.camerarentbackend.core.client.dto;

public record ClientRegisterRequest(
        String name,
        String surname,
        String email,
        String password,
        String phoneNumber,
        Long cityId,
        Long clientTypeId
) {
}
