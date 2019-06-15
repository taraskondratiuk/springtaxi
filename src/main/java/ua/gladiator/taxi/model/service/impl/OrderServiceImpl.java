package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Order;
import ua.gladiator.taxi.model.repository.OrderRepository;
import ua.gladiator.taxi.model.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getRidesByClientId(Long id) {
        return orderRepository.findAllByClientId(id);
    }

    @Override
    public Integer getNumRides(Long id) {
        return orderRepository.findAllByClientId(id).size();
    }
}
