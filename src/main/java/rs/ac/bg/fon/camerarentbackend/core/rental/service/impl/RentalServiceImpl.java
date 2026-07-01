package rs.ac.bg.fon.camerarentbackend.core.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.camera.repository.CameraRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.repository.ClientRepository;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.rental.mapper.RentalMapper;
import rs.ac.bg.fon.camerarentbackend.core.rental.repository.RentalRepository;
import rs.ac.bg.fon.camerarentbackend.core.rental.service.RentalService;
import rs.ac.bg.fon.camerarentbackend.core.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final CameraRepository cameraRepository;
    private final RentalMapper rentalMapper;

    @Override
    public RentalResponseDto create(RentalRequestDto requestDto) {
        Rental rental = new Rental();
        rental.setStartDate(requestDto.startDate());
        rental.setEndDate(requestDto.endDate());
        rental.setStatus(requestDto.status());
        
        var client = clientRepository.findById(requestDto.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + requestDto.clientId()));
        rental.setClient(client);
        
        var user = userRepository.findById(requestDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + requestDto.userId()));
        rental.setUser(user);
        
        var camera = cameraRepository.findById(requestDto.cameraId())
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + requestDto.cameraId()));
        rental.setCamera(camera);
        
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.toResponseDto(savedRental);
    }

    @Override
    public RentalResponseDto update(Long id, RentalRequestDto requestDto) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found with id: " + id));
        
        rental.setStartDate(requestDto.startDate());
        rental.setEndDate(requestDto.endDate());
        rental.setStatus(requestDto.status());
        
        var client = clientRepository.findById(requestDto.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + requestDto.clientId()));
        rental.setClient(client);
        
        var user = userRepository.findById(requestDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + requestDto.userId()));
        rental.setUser(user);
        
        var camera = cameraRepository.findById(requestDto.cameraId())
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + requestDto.cameraId()));
        rental.setCamera(camera);
        
        Rental updatedRental = rentalRepository.save(rental);
        return rentalMapper.toResponseDto(updatedRental);
    }

    @Override
    public RentalResponseDto getById(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found with id: " + id));
        return rentalMapper.toResponseDto(rental);
    }

    @Override
    public List<RentalResponseDto> getAll() {
        return rentalRepository.findAll()
                .stream()
                .map(rentalMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        rentalRepository.deleteById(id);
    }
}
