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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.proyecto.coderhouse.backend_coderhouse.entity.DeliveryEntity;
import backend.proyecto.coderhouse.backend_coderhouse.service.DeliveryService;


@RestController
@RequestMapping("api/delivery")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DeliveryEntity>> getDeliveries() {
        try {
            List<DeliveryEntity> deliveries = deliveryService.getDeliveries();
            return ResponseEntity.ok(deliveries);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(value = "/agregar", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DeliveryEntity> save(@RequestBody DeliveryEntity delivery) {
        try {
            DeliveryEntity deliverySaved = deliveryService.save(delivery);
            return ResponseEntity.ok(deliverySaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DeliveryEntity>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(deliveryService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
