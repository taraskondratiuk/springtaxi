package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Order;

import java.util.List;


@Service
public interface OrderService {
    void addOrder(Order order);

    List <Order> getRidesByClientId(Long id);
    Integer getNumRides (Long id);
}
