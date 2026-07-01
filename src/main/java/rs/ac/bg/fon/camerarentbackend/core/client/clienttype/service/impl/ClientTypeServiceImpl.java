package rs.ac.bg.fon.camerarentbackend.core.client.clienttype.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.mapper.ClientTypeMapper;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.repository.ClientTypeRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.service.ClientTypeService;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.entity.ClientType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientTypeServiceImpl implements ClientTypeService {

    private final ClientTypeRepository clientTypeRepository;
    private final ClientTypeMapper clientTypeMapper;

    @Override
    public ClientTypeResponseDto create(ClientTypeRequestDto requestDto) {
        ClientType clientType = clientTypeMapper.toEntity(requestDto);
        ClientType savedClientType = clientTypeRepository.save(clientType);
        return clientTypeMapper.toResponseDto(savedClientType);
    }

    @Override
    public ClientTypeResponseDto update(Long id, ClientTypeRequestDto requestDto) {
        ClientType clientType = clientTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ClientType not found with id: " + id));
        clientType.setName(requestDto.name());
        ClientType updatedClientType = clientTypeRepository.save(clientType);
        return clientTypeMapper.toResponseDto(updatedClientType);
    }

    @Override
    public ClientTypeResponseDto getById(Long id) {
        ClientType clientType = clientTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ClientType not found with id: " + id));
        return clientTypeMapper.toResponseDto(clientType);
    }

    @Override
    public List<ClientTypeResponseDto> getAll() {
        return clientTypeRepository.findAll()
                .stream()
                .map(clientTypeMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        clientTypeRepository.deleteById(id);
    }
}
