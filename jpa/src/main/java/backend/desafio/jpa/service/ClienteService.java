package backend.desafio.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.desafio.jpa.entity.ClienteEntity;
import backend.desafio.jpa.repository.ClienteRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public String nombre;
    public String apellido;
    public int edad;

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteService calculateAge(Long id) {

        // Crear objeto custom para responder en la API
        ClienteService clienteResponseToApi = new ClienteService();
        // Calcular edad y establecer formato
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac =
                LocalDate.parse(clienteRepository.findById(id).get().getNacimiento(), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        // Setear objeto para responder en la API
        clienteResponseToApi.nombre = clienteRepository.findById(id).get().getNombre();
        clienteResponseToApi.apellido = clienteRepository.findById(id).get().getApellido();
        clienteResponseToApi.edad = periodo.getYears();

        return clienteResponseToApi;
    }
}
