package rs.ac.bg.fon.camerarentbackend.core.camera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {

    @Query("""
        SELECT c
        FROM Camera c
        WHERE c.id NOT IN (
            SELECT r.camera.id
            FROM Rental r
            WHERE r.startDate <= :endDate
              AND r.endDate >= :startDate
        )
    """)
    List<Camera> findAvailableCameras(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
