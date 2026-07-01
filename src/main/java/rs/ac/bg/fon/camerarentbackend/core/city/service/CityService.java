package rs.ac.bg.fon.camerarentbackend.core.city.service;

import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;

import java.util.List;

public interface CityService {

    CityResponseDto create(CityRequestDto requestDto);

    CityResponseDto update(Long id, CityRequestDto requestDto);

    CityResponseDto getById(Long id);

    List<CityResponseDto> getAll();

    void delete(Long id);
}
