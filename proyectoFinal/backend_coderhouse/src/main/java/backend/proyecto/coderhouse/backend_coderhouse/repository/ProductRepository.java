package backend.proyecto.coderhouse.backend_coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
