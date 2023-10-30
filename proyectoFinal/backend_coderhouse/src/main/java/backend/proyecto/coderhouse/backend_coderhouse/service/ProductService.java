package backend.proyecto.coderhouse.backend_coderhouse.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ProductEntity;
import backend.proyecto.coderhouse.backend_coderhouse.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String nombre;
    public String descripcion;
    public int precio;
    public String imagePath;

    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductEntity updateProductById(Long id, ProductEntity product) {
        ProductEntity optionalProduct = productRepository.findById(id).get();

        // Modify the fields of the entity object
        optionalProduct.setNombre(product.getNombre());
        optionalProduct.setDescripcion(product.getDescripcion());
        optionalProduct.setPrecio(product.getPrecio());
        optionalProduct.setImagePath(product.getImagePath());
        return productRepository.save(optionalProduct);
    }
}
