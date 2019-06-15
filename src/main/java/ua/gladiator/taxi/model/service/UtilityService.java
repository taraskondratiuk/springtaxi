package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.entity.Order;
import ua.gladiator.taxi.model.entity.OrderDetailsDTO;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

import java.util.List;

@Service
public interface UtilityService {

    public Long countPrice(Integer discount, Long time);
    public List<OrderDetailsDTO> buildListDetails(List<Order> orders);

}
