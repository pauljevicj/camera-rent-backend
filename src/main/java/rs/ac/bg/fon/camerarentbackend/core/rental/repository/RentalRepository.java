package rs.ac.bg.fon.camerarentbackend.core.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.rental.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
