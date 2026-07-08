package rs.ac.bg.fon.camerarentbackend.core.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.RentalStatus;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByStatus(RentalStatus status);

    @Query("""
    SELECT r
    FROM Rental r
    WHERE r.status <> 'PENDING'
    """)
    List<Rental> findProcessed();

    @Query("""
    SELECT r
    FROM Rental r
    WHERE r.status = 'APPROVED'
        AND r.endDate < :today
    """)
    List<Rental> findExpired(LocalDate today);
}
