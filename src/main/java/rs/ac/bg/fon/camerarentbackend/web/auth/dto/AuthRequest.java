package rs.ac.bg.fon.camerarentbackend.web.auth.dto;

public record AuthRequest(
        String email,
        String password
) {
}
