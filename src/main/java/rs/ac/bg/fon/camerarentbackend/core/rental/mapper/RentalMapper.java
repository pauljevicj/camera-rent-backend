package rs.ac.bg.fon.camerarentbackend.core.rental.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    RentalResponseDto toResponseDto(Rental rental);

    Rental toEntity(RentalRequestDto requestDto);
}

