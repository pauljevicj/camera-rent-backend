package rs.ac.bg.fon.camerarentbackend.core.city.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.city.entity.City;
import rs.ac.bg.fon.camerarentbackend.core.city.mapper.CityMapper;
import rs.ac.bg.fon.camerarentbackend.core.city.repository.CityRepository;
import rs.ac.bg.fon.camerarentbackend.core.city.service.CityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public CityResponseDto create(CityRequestDto requestDto) {
        City city = cityMapper.toEntity(requestDto);
        City savedCity = cityRepository.save(city);
        return cityMapper.toResponseDto(savedCity);
    }

    @Override
    public CityResponseDto update(Long id, CityRequestDto requestDto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + id));
        city.setName(requestDto.name());
        City updatedCity = cityRepository.save(city);
        return cityMapper.toResponseDto(updatedCity);
    }

    @Override
    public CityResponseDto getById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + id));
        return cityMapper.toResponseDto(city);
    }

    @Override
    public List<CityResponseDto> getAll() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
