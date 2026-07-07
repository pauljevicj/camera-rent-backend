package rs.ac.bg.fon.camerarentbackend.core.camera.dto;

public record CameraRequestDto(
        Double pricePerDay,
        String cameraCondition,
        Integer year,
        Long cameraModelId
) {}
