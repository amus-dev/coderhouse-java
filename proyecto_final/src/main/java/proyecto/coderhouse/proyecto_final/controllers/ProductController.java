package proyecto.coderhouse.proyecto_final.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.coderhouse.proyecto_final.entities.ProductEntity;
import proyecto.coderhouse.proyecto_final.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
        try {
            ProductEntity productSaved = productService.save(product);
            return ResponseEntity.ok(productSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductEntity>> getProducts() {
        try {
            List<ProductEntity> products = productService.getProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ProductEntity>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
