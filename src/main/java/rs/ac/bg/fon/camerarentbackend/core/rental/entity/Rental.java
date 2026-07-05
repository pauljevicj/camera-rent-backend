package rs.ac.bg.fon.camerarentbackend.core.rental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.employee.entity.Employee;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee user;

    @ManyToOne
    @JoinColumn(name = "camera_id", nullable = false)
    private Camera camera;
}
