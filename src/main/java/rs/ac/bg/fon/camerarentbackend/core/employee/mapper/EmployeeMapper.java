package rs.ac.bg.fon.camerarentbackend.core.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeResponseDto toResponseDto(Employee user);

    Employee toEntity(EmployeeRequestDto requestDto);

    void update(@MappingTarget Employee user, EmployeeRequestDto requestDto);
}

