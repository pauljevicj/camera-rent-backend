package rs.ac.bg.fon.camerarentbackend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.camerarentbackend.core.city.repository.CityRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.client.repository.ClientRepository;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.repository.ClientTypeRepository;
import rs.ac.bg.fon.camerarentbackend.infrastructure.security.jwt.JwtTokenProvider;
import rs.ac.bg.fon.camerarentbackend.core.client.dto.ClientRegisterRequest;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication endpoints for JWT token generation")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;
    private final ClientTypeRepository clientTypeRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user/login")
    @Operation(summary = "User Login", description = "Authenticate user with email and password to receive JWT token")
    public ResponseEntity<Object> userLogin(@RequestBody HashMap<String, String> auth) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            auth.get("email"),
                            auth.get("password")
                    )
            );

            String token = jwtTokenProvider.generateToken(
                    authentication.getName(),
                    authentication.getAuthorities().stream().toList()
            );

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/client/login")
    @Operation(summary = "Client Login", description = "Authenticate client with email and password to receive JWT token")
    public ResponseEntity<Object> clientLogin(@RequestBody HashMap<String, String> auth) {
        try {
            var client = clientRepository.findByEmail(auth.get("email"))
                    .orElseThrow(() -> new RuntimeException("Client not found"));

            if (!passwordEncoder.matches(auth.get("password"), client.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String token = jwtTokenProvider.generateToken(auth.get("email"));

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/client/register")
    @Operation(summary = "Client Register", description = "Register a new client account")
    public ResponseEntity<?> clientRegister(@RequestBody ClientRegisterRequest request) {
        try {
            if (clientRepository.findByEmail(request.email()).isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Email already registered");
            }

            var city = cityRepository.findById(request.cityId())
                    .orElseThrow(() -> new RuntimeException("City not found"));

            var clientType = clientTypeRepository.findById(request.clientTypeId())
                    .orElseThrow(() -> new RuntimeException("ClientType not found"));

            Client client = new Client();
            client.setName(request.name());
            client.setSurname(request.surname());
            client.setEmail(request.email());
            client.setPassword(passwordEncoder.encode(request.password()));
            client.setPhoneNumber(request.phoneNumber());
            client.setCity(city);
            client.setClientType(clientType);

            clientRepository.save(client);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Client registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Registration failed: " + e.getMessage());
        }
    }
}
