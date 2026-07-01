package rs.ac.bg.fon.camerarentbackend.core.client.clienttype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.camerarentbackend.core.client.clienttype.entity.ClientType;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
