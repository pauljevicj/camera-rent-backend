package rs.ac.bg.fon.camerarentbackend.core.camera.dto;

import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;

public record CameraRequestDto(
        String status,
        Double pricePerDay,
        String cameraCondition,
        Integer year,
        Long cameraModelId
) {}
