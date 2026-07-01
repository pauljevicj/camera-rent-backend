package rs.ac.bg.fon.camerarentbackend.core.rental.dto;

import java.time.LocalDate;

public record RentalRequestDto(
        LocalDate startDate,
        LocalDate endDate,
        String status,
        Long clientId,
        Long userId,
        Long cameraId
) {}
