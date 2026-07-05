package rs.ac.bg.fon.camerarentbackend.core.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.camera.service.CameraService;
import rs.ac.bg.fon.camerarentbackend.core.client.service.ClientService;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.user.service.UserService;

@Mapper(componentModel = "spring", uses = {
        UserService.class, ClientService.class, CameraService.class
})
public interface RentalMapper {

    RentalResponseDto toResponseDto(Rental rental);

    @Mapping(target = "client", source = "clientId")
    @Mapping(target = "camera", source = "cameraId")
    @Mapping(target = "user", source = "userId")
    Rental toEntity(RentalRequestDto requestDto);

    void update(@MappingTarget Rental rental, RentalRequestDto requestDto);
}

