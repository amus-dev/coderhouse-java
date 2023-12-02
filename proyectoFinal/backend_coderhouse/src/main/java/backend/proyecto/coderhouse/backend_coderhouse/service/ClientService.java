package backend.proyecto.coderhouse.backend_coderhouse.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.proyecto.coderhouse.backend_coderhouse.entity.ClientEntity;
import backend.proyecto.coderhouse.backend_coderhouse.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity save(ClientEntity client) {
        return clientRepository.save(client);
    }

    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
