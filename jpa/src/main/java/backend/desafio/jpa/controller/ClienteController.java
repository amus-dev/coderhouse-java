package backend.desafio.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.desafio.jpa.entity.ClienteEntity;
import backend.desafio.jpa.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClienteService> calculateAge(@PathVariable Long id) {
        ClienteService cliente = clienteService.calculateAge(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity cliente) {
        try {
            ClienteEntity clienteSaved = clienteService.save(cliente);
            return ResponseEntity.ok(clienteSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
