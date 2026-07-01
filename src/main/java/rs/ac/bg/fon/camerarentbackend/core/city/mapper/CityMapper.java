package rs.ac.bg.fon.camerarentbackend.core.city.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.city.entity.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityResponseDto toResponseDto(City city);

    City toEntity(CityRequestDto requestDto);
}
