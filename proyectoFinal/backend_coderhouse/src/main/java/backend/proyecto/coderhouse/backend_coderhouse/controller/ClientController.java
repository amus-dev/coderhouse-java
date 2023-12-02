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
import backend.proyecto.coderhouse.backend_coderhouse.entity.ClientEntity;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ProductEntity;
import backend.proyecto.coderhouse.backend_coderhouse.service.ClientService;
import backend.proyecto.coderhouse.backend_coderhouse.service.ProductService;


@RestController
@RequestMapping("api/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ClientEntity>> getClients() {
        try {
            List<ClientEntity> clients = clientService.getClients();
            return ResponseEntity.ok(clients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(value = "/agregar", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client) {
        try {
            ClientEntity clientSaved = clientService.save(client);
            return ResponseEntity.ok(clientSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ClientEntity>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<List<ClientEntity>> deleteClientById(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
        List<ClientEntity> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }
}
