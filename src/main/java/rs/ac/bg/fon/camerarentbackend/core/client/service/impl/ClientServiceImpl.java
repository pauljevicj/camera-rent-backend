package rs.ac.bg.fon.camerarentbackend.core.client.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.city.repository.CityRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.repository.ClientTypeRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.entity.ClientType;
import rs.ac.bg.fon.camerarentbackend.core.client.mapper.ClientMapper;
import rs.ac.bg.fon.camerarentbackend.core.client.repository.ClientRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.service.ClientService;
import rs.ac.bg.fon.camerarentbackend.core.city.entity.City;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;
    private final ClientTypeRepository clientTypeRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDto create(ClientRequestDto requestDto) {
        Client client = new Client();
        client.setName(requestDto.name());
        client.setSurname(requestDto.surname());
        client.setEmail(requestDto.email());
        client.setPhoneNumber(requestDto.phoneNumber());
        
        City city = cityRepository.findById(requestDto.cityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + requestDto.cityId()));
        client.setCity(city);
        
        ClientType clientType = clientTypeRepository.findById(requestDto.clientTypeId())
                .orElseThrow(() -> new IllegalArgumentException("ClientType not found with id: " + requestDto.clientTypeId()));
        client.setClientType(clientType);
        
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(savedClient);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto requestDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
        
        client.setName(requestDto.name());
        client.setSurname(requestDto.surname());
        client.setEmail(requestDto.email());
        client.setPhoneNumber(requestDto.phoneNumber());
        
        City city = cityRepository.findById(requestDto.cityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + requestDto.cityId()));
        client.setCity(city);
        
        ClientType clientType = clientTypeRepository.findById(requestDto.clientTypeId())
                .orElseThrow(() -> new IllegalArgumentException("ClientType not found with id: " + requestDto.clientTypeId()));
        client.setClientType(clientType);
        
        Client updatedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(updatedClient);
    }

    @Override
    public ClientResponseDto getById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
        return clientMapper.toResponseDto(client);
    }

    @Override
    public List<ClientResponseDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
