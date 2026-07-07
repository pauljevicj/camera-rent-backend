package rs.ac.bg.fon.camerarentbackend.core.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.account.entity.Account;
import rs.ac.bg.fon.camerarentbackend.core.account.repository.AccountRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.client.repository.ClientRepository;
import rs.ac.bg.fon.camerarentbackend.core.employee.repository.EmployeeRepository;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.RentalStatus;
import rs.ac.bg.fon.camerarentbackend.core.rental.mapper.RentalMapper;
import rs.ac.bg.fon.camerarentbackend.core.rental.repository.RentalRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public RentalResponseDto create(RentalRequestDto requestDto) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Client client = clientRepository.findByAccountId(account.getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Rental rental = rentalMapper.toEntity(requestDto);

        rental.setClient(client);
        rental.setStatus(RentalStatus.PENDING);

        return rentalMapper.toResponseDto(rentalRepository.save(rental));
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
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        var employee = employeeRepository.findByAccountId(account.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));


        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found with id: " + id));


        rental.setStatus(RentalStatus.APPROVED);
        rental.setEmployee(employee);


        Rental updatedRental = rentalRepository.save(rental);

        return rentalMapper.toResponseDto(updatedRental);
    }

    @Override
    public List<RentalResponseDto> getByStatus(RentalStatus status) {
        return rentalRepository.findByStatus(status)
                .stream()
                .map(rentalMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<RentalResponseDto> getAllProcessed() {
        return rentalRepository.findProcessed()
                .stream()
                .map(rentalMapper::toResponseDto)
                .toList();
    }
}
