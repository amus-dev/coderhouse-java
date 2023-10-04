package proyecto.coderhouse.proyecto_final.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.coderhouse.proyecto_final.entities.ProductEntity;
import proyecto.coderhouse.proyecto_final.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }
}
