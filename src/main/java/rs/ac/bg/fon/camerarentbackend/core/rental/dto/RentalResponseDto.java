package rs.ac.bg.fon.camerarentbackend.core.rental.dto;

import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserResponseDto;

import java.time.LocalDate;

public record RentalResponseDto(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        String status,
        ClientResponseDto client,
        UserResponseDto user,
        CameraResponseDto camera
) {}
