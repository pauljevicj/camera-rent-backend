package rs.ac.bg.fon.camerarentbackend.core.client.service;

import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientUpdateDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;

import java.util.List;

public interface ClientService {

    ClientResponseDto create(ClientRequestDto requestDto);

    ClientResponseDto update(Long id, ClientUpdateDto clientUpdateDto);

    ClientResponseDto getById(Long id);

    List<ClientResponseDto> getAll();

    void delete(Long id);

    Client toEntity(Long id);

    ClientResponseDto register(ClientRequestDto requestDto);
}
