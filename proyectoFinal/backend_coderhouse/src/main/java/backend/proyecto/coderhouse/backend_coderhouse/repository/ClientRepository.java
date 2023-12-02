package backend.proyecto.coderhouse.backend_coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
