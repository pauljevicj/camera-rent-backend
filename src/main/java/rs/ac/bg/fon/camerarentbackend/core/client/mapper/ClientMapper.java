package rs.ac.bg.fon.camerarentbackend.core.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.city.service.CityService;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientUpdateDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;

@Mapper(componentModel = "spring", uses = {CityService.class})
public interface ClientMapper {

    @Mapping(target = "email", source = "account.email")
    ClientResponseDto toResponseDto(Client client);

    @Mapping(target = "city", source = "cityId")
    Client toEntity(ClientRequestDto requestDto);

    @Mapping(target = "city", source = "cityId")
    @Mapping(target = "account.email", source = "email")
    void update(@MappingTarget Client client, ClientUpdateDto updateDto);
}

