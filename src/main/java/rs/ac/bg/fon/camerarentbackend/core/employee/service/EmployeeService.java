package rs.ac.bg.fon.camerarentbackend.core.employee.service;

import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto create(EmployeeRequestDto requestDto);

    EmployeeResponseDto update(Long id, EmployeeRequestDto requestDto);

    EmployeeResponseDto getById(Long id);

    List<EmployeeResponseDto> getAll();

    void delete(Long id);

    Employee toEntity(Long id);
}
