package rs.ac.bg.fon.camerarentbackend.web.camera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.service.CameraService;

import java.util.List;

@RestController
@RequestMapping("/api/cameras")
@RequiredArgsConstructor
@Tag(name = "Cameras", description = "Camera management APIs")
public class CameraController {

    private final CameraService cameraService;

    @PostMapping
    @Operation(summary = "Create a new camera", description = "Create a new camera with the provided details")
    public ResponseEntity<CameraResponseDto> create(@RequestBody CameraRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cameraService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a camera", description = "Update an existing camera by ID")
    public ResponseEntity<CameraResponseDto> update(
            @PathVariable Long id,
            @RequestBody CameraRequestDto requestDto) {
        return ResponseEntity.ok(cameraService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get camera by ID", description = "Retrieve a camera by their ID")
    public ResponseEntity<CameraResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cameraService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all cameras", description = "Retrieve all cameras")
    public ResponseEntity<List<CameraResponseDto>> getAll() {
        return ResponseEntity.ok(cameraService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a camera", description = "Delete a camera by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cameraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
