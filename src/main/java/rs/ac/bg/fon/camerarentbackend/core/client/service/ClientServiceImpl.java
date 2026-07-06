package rs.ac.bg.fon.camerarentbackend.core.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.account.entity.Account;
import rs.ac.bg.fon.camerarentbackend.core.account.entity.Role;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.client.mapper.ClientMapper;
import rs.ac.bg.fon.camerarentbackend.core.client.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientResponseDto create(ClientRequestDto requestDto) {
        Client savedClient = clientRepository.save(clientMapper.toEntity(requestDto));
        return clientMapper.toResponseDto(savedClient);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto requestDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));

        clientMapper.update(client, requestDto);
        return clientMapper.toResponseDto(clientRepository.save(client));
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

    @Override
    public Client toEntity(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    @Override
    public ClientResponseDto register(ClientRequestDto requestDto) {
        Account account = new Account();
        account.setEmail(requestDto.account().email());
        account.setPassword(passwordEncoder.encode(requestDto.account().password()));
        account.setRole(Role.CLIENT);

        Client client = clientMapper.toEntity(requestDto);
        client.setAccount(account);

        return clientMapper.toResponseDto(clientRepository.save(client));
    }
}
