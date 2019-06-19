package ua.gladiator.taxi.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.*;
import ua.gladiator.taxi.model.entity.dto.CarDetailsDTO;
import ua.gladiator.taxi.model.entity.dto.ClientDetailsDTO;
import ua.gladiator.taxi.model.entity.dto.OrderDetailsDTO;

@Service
public interface UtilityService {

    Long countPrice(Integer discount, Long time);
    Page<OrderDetailsDTO> buildPageOrders(Pageable pageable, Client client);
    Page<CarDetailsDTO> buildPageCars(Pageable pageable);
    Page<ClientDetailsDTO> buildPageClients(Pageable pageable);

}
