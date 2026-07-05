package rs.ac.bg.fon.camerarentbackend.core.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.rental.mapper.RentalMapper;
import rs.ac.bg.fon.camerarentbackend.core.rental.repository.RentalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    @Override
    public RentalResponseDto create(RentalRequestDto requestDto) {
        Rental savedRental = rentalRepository.save(rentalMapper.toEntity(requestDto));
        return rentalMapper.toResponseDto(savedRental);
    }

    @Override
    public RentalResponseDto update(Long id, RentalRequestDto requestDto) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found with id: " + id));

        rentalMapper.update(rental, requestDto);
        return rentalMapper.toResponseDto(rentalRepository.save(rental));
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

    @Override
    public RentalResponseDto approve(Long id) {
        return rentalRepository.findById(id)
                .map(rental -> {
                    rental.setStatus("APPROVED");
                    Rental updatedRental = rentalRepository.save(rental);
                    return rentalMapper.toResponseDto(updatedRental);
                })
                .orElseThrow(() -> new IllegalArgumentException("Rental not found with id: " + id));
    }

    @Override
    public List<RentalResponseDto> getByStatus(String status) {
        return rentalRepository.findByStatus(status)
                .stream()
                .map(rentalMapper::toResponseDto)
                .toList();
    }
}
