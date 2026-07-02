package rs.ac.bg.fon.camerarentbackend.web.auth.dto;

public record AuthResponse(
        String accessToken,
        String tokenType,
        Long expiresIn
) {
}
