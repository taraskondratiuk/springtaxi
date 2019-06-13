package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;

import ua.gladiator.taxi.model.repository.DiscountRepository;
import ua.gladiator.taxi.model.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }


    @Override
    public Integer getClientDiscount(Client client) {
        return Math.max(
                discountRepository.getPersonalDiscount(client.getTotalSpentValue(), client.getSocialStatus().toString()),
                discountRepository.getSpecialDiscount());
    }

    @Override
    public Integer getSpecialDiscount() {
        return discountRepository.getSpecialDiscount();
    }
}
