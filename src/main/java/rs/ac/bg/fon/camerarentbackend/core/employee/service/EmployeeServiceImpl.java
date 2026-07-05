package rs.ac.bg.fon.camerarentbackend.core.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.entity.Employee;
import rs.ac.bg.fon.camerarentbackend.core.employee.mapper.EmployeeMapper;
import rs.ac.bg.fon.camerarentbackend.core.employee.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto requestDto) {
        Employee savedUser = employeeRepository.save(employeeMapper.toEntity(requestDto));
        return employeeMapper.toResponseDto(savedUser);
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto requestDto) {
        Employee user = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        employeeMapper.update(user, requestDto);
        return employeeMapper.toResponseDto(employeeRepository.save(user));
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        Employee user = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return employeeMapper.toResponseDto(user);
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee toEntity(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
}
