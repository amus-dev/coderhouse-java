package backend.proyecto.coderhouse.backend_coderhouse.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ProductEntity;
import backend.proyecto.coderhouse.backend_coderhouse.service.ProductService;


@RestController
@RequestMapping("api/producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductEntity>> getProducts() {
        try {
            List<ProductEntity> products = productService.getProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(value = "/agregar", produces = {MediaType.APPLICATION_JSON_VALUE},
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ProductEntity>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<List<ProductEntity>> deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        List<ProductEntity> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping(value = "/editar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductEntity> updateProductById(@PathVariable("id") Long id,
            @RequestBody ProductEntity product) {
        try {
            ProductEntity productSaved = productService.updateProductById(id, product);
            return ResponseEntity.ok(productSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
