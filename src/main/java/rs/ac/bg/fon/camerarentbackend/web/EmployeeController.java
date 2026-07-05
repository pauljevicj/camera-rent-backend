package rs.ac.bg.fon.camerarentbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.dto.EmployeeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.employee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employees", description = "Employee management APIs")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @Operation(summary = "Create a new employee", description = "Create a new employee with the provided details")
    public ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an employee", description = "Update an existing employee by ID")
    public ResponseEntity<EmployeeResponseDto> update(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDto requestDto) {
        return ResponseEntity.ok(employeeService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Retrieve an employee by their ID")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all employees", description = "Retrieve all employees")
    public ResponseEntity<List<EmployeeResponseDto>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee", description = "Delete an employee by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
