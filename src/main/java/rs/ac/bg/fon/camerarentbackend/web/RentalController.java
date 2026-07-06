package rs.ac.bg.fon.camerarentbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.dto.RentalResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.RentalStatus;
import rs.ac.bg.fon.camerarentbackend.core.rental.service.RentalService;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
@Tag(name = "Rentals", description = "Rental management APIs")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    @Operation(summary = "Create a new rental", description = "Create a new rental with the provided details")
    public ResponseEntity<RentalResponseDto> create(@RequestBody RentalRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rentalService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a rental", description = "Update an existing rental by ID")
    public ResponseEntity<RentalResponseDto> update(
            @PathVariable Long id,
            @RequestBody RentalRequestDto requestDto) {
        return ResponseEntity.ok(rentalService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rental by ID", description = "Retrieve a rental by their ID")
    public ResponseEntity<RentalResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all rentals", description = "Retrieve all rentals")
    public ResponseEntity<List<RentalResponseDto>> getAll(@RequestParam(required = false) RentalStatus status) {
        if (status == null) {
            return ResponseEntity.ok(rentalService.getAll());
        }

        return ResponseEntity.ok(rentalService.getByStatus(status));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a rental", description = "Delete a rental by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/approve")
    @Operation(summary = "Approve a rental", description = "Approve a rental")
    public ResponseEntity<RentalResponseDto> approve(
            @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.approve(id));
    }

    @GetMapping("/processed")
    @Operation(summary = "Get all processed rentals", description = "Retrieve all processed rentals")
    public ResponseEntity<List<RentalResponseDto>> getAllProcessed() {
        return ResponseEntity.ok(rentalService.getAllProcessed());
    }
}
