package rs.ac.bg.fon.camerarentbackend.core.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.city.service.CityService;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.service.ClientTypeService;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;

@Mapper(componentModel = "spring", uses = {ClientTypeService.class, CityService.class})
public interface ClientMapper {

    ClientResponseDto toResponseDto(Client client);

    @Mapping(target = "clientType", source = "clientTypeId")
    @Mapping(target = "city", source = "cityId")
    Client toEntity(ClientRequestDto requestDto);

    void update(@MappingTarget Client client, ClientRequestDto requestDto);
}

