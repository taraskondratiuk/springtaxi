package ua.gladiator.taxi.model.service;

import ua.gladiator.taxi.model.entity.Client;
import org.springframework.stereotype.Service;

@Service
public interface DiscountService {
    Integer getClientDiscount(Client client);

    Integer getSpecialDiscount();
}
