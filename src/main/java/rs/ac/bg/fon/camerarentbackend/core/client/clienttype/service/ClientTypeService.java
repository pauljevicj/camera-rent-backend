package rs.ac.bg.fon.camerarentbackend.core.client.clienttype.service;

import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.entity.ClientType;

import java.util.List;

public interface ClientTypeService {

    ClientTypeResponseDto create(ClientTypeRequestDto requestDto);

    ClientTypeResponseDto update(Long id, ClientTypeRequestDto requestDto);

    ClientTypeResponseDto getById(Long id);

    List<ClientTypeResponseDto> getAll();

    void delete(Long id);

    ClientType toEntity(Long id);
}
