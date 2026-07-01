package rs.ac.bg.fon.camerarentbackend.web.city.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.city.dto.CityResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.city.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
@Tag(name = "Cities", description = "City management APIs")
public class CityController {

    private final CityService cityService;

    @PostMapping
    @Operation(summary = "Create a new city", description = "Create a new city with the provided details")
    public ResponseEntity<CityResponseDto> create(@RequestBody CityRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cityService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a city", description = "Update an existing city by ID")
    public ResponseEntity<CityResponseDto> update(
            @PathVariable Long id,
            @RequestBody CityRequestDto requestDto) {
        return ResponseEntity.ok(cityService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get city by ID", description = "Retrieve a city by their ID")
    public ResponseEntity<CityResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all cities", description = "Retrieve all cities")
    public ResponseEntity<List<CityResponseDto>> getAll() {
        return ResponseEntity.ok(cityService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a city", description = "Delete a city by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
