package rs.ac.bg.fon.camerarentbackend.core.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
