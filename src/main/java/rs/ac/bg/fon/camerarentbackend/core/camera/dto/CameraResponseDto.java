package rs.ac.bg.fon.camerarentbackend.core.camera.dto;

import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;

public record CameraResponseDto(
        Long id,
        Double pricePerDay,
        String cameraCondition,
        Integer year,
        CameraModelResponseDto cameraModel
) {}
