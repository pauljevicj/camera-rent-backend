package rs.ac.bg.fon.camerarentbackend.web.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.dto.ClientTypeResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.service.ClientTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/client-types")
@RequiredArgsConstructor
@Tag(name = "Client Types", description = "Client type management APIs")
public class ClientTypeController {

    private final ClientTypeService clientTypeService;

    @PostMapping
    @Operation(summary = "Create a new client type", description = "Create a new client type with the provided details")
    public ResponseEntity<ClientTypeResponseDto> create(@RequestBody ClientTypeRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientTypeService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a client type", description = "Update an existing client type by ID")
    public ResponseEntity<ClientTypeResponseDto> update(
            @PathVariable Long id,
            @RequestBody ClientTypeRequestDto requestDto) {
        return ResponseEntity.ok(clientTypeService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client type by ID", description = "Retrieve a client type by their ID")
    public ResponseEntity<ClientTypeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientTypeService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all client types", description = "Retrieve all client types")
    public ResponseEntity<List<ClientTypeResponseDto>> getAll() {
        return ResponseEntity.ok(clientTypeService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client type", description = "Delete a client type by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
