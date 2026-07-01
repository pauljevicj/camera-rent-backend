package rs.ac.bg.fon.camerarentbackend.core.rental.entity;

import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;
import rs.ac.bg.fon.camerarentbackend.core.client.entity.Client;
import rs.ac.bg.fon.camerarentbackend.core.user.entity.User;

import java.time.LocalDate;

public class Rental {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private User user;
    private Camera camera;
}
