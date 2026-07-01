package rs.ac.bg.fon.camerarentbackend.core.client.service;

import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto create(ClientRequestDto requestDto);

    ClientResponseDto update(Long id, ClientRequestDto requestDto);

    ClientResponseDto getById(Long id);

    List<ClientResponseDto> getAll();

    void delete(Long id);
}
