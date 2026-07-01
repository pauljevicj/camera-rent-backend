package rs.ac.bg.fon.camerarentbackend.core.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.city.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
