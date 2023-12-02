package backend.proyecto.coderhouse.backend_coderhouse.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.proyecto.coderhouse.backend_coderhouse.entity.DeliveryEntity;
import backend.proyecto.coderhouse.backend_coderhouse.repository.DeliveryRepository;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryEntity save(DeliveryEntity delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<DeliveryEntity> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<DeliveryEntity> findById(Long id) {
        return deliveryRepository.findById(id);
    }
}
