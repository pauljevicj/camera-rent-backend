package rs.ac.bg.fon.camerarentbackend.core.rental.service;

import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.RentalStatus;

import java.util.List;

public interface RentalService {

    RentalResponseDto create(RentalRequestDto requestDto);

    RentalResponseDto update(Long id, RentalRequestDto requestDto);

    RentalResponseDto getById(Long id);

    List<RentalResponseDto> getAll();

    void delete(Long id);

    RentalResponseDto approve(Long id);

    List<RentalResponseDto> getByStatus(RentalStatus status);
}
