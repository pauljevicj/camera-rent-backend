package rs.ac.bg.fon.camerarentbackend.core.camera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {
}
