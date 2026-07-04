package rs.ac.bg.fon.camerarentbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.service.CameraModelService;

import java.util.List;

@RestController
@RequestMapping("/api/camera-models")
@RequiredArgsConstructor
@Tag(name = "Camera Models", description = "Camera model management APIs")
public class CameraModelController {

    private final CameraModelService cameraModelService;

    @PostMapping
    @Operation(summary = "Create a new camera model", description = "Create a new camera model with the provided details")
    public ResponseEntity<CameraModelResponseDto> create(@RequestBody CameraModelRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cameraModelService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a camera model", description = "Update an existing camera model by ID")
    public ResponseEntity<CameraModelResponseDto> update(
            @PathVariable Long id,
            @RequestBody CameraModelRequestDto requestDto) {
        return ResponseEntity.ok(cameraModelService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get camera model by ID", description = "Retrieve a camera model by their ID")
    public ResponseEntity<CameraModelResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cameraModelService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all camera models", description = "Retrieve all camera models")
    public ResponseEntity<List<CameraModelResponseDto>> getAll() {
        return ResponseEntity.ok(cameraModelService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a camera model", description = "Delete a camera model by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cameraModelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
