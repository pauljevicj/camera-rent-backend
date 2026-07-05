package rs.ac.bg.fon.camerarentbackend.core.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientResponseDto toResponseDto(Client client);

    Client toEntity(ClientRequestDto requestDto);

    void update(@MappingTarget Client client, ClientRequestDto requestDto);
}

