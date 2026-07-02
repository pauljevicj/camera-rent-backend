package rs.ac.bg.fon.camerarentbackend.core.client.clienttype.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.entity.ClientType;

@Mapper(componentModel = "spring")
public interface ClientTypeMapper {

    ClientTypeResponseDto toResponseDto(ClientType clientType);

    ClientType toEntity(ClientTypeRequestDto requestDto);
}

