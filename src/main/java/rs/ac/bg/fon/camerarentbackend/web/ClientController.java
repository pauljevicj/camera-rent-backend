package rs.ac.bg.fon.camerarentbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientUpdateDto;
import rs.ac.bg.fon.camerarentbackend.core.client.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clients", description = "Client management APIs")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @Operation(summary = "Create a new client", description = "Create a new client with the provided details")
    public ResponseEntity<ClientResponseDto> create(@RequestBody ClientRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.create(requestDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a client", description = "Update an existing client by ID")
    public ResponseEntity<ClientResponseDto> update(
            @PathVariable Long id,
            @RequestBody ClientUpdateDto clientUpdateDto) {
        return ResponseEntity.ok(clientService.update(id, clientUpdateDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID", description = "Retrieve a client by their ID")
    public ResponseEntity<ClientResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getById(id));
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieve all clients")
    public ResponseEntity<List<ClientResponseDto>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client", description = "Delete a client by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
