package rs.ac.bg.fon.camerarentbackend.core.camera.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Double pricePerDay;

    private String cameraCondition;

    @ManyToOne
    @JoinColumn(name = "camera_model_id", nullable = false)
    private CameraModel cameraModel;

}
