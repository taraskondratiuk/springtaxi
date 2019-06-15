package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Order;
import ua.gladiator.taxi.model.entity.OrderDetailsDTO;
import ua.gladiator.taxi.model.repository.CarRepository;
import ua.gladiator.taxi.model.repository.DiscountRepository;
import ua.gladiator.taxi.model.repository.TimeRepository;
import ua.gladiator.taxi.model.service.UtilityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {

    private final TimeRepository timeRepository;
    private final CarRepository carRepository;


    public UtilityServiceImpl(TimeRepository timeRepository, CarRepository carRepository) {
        this.timeRepository = timeRepository;
        this.carRepository = carRepository;

    }

    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public List<OrderDetailsDTO> buildListDetails(List<Order> orders) {
        List <OrderDetailsDTO> list = new ArrayList<>();
        orders.forEach(v -> list.add(OrderDetailsDTO
                .builder()
                .price(v.getPrice())
                .carMake(carRepository.getMakeById(v.getCar_id()))
                .carType(carRepository.getTypeById(v.getCar_id()))
                .destPlace(timeRepository.getDestById(v.getTime_id()))
                .initPlace(timeRepository.getInitById(v.getTime_id()))
                .time(timeRepository.getLongTimeById(v.getTime_id()))
        .build()));
        return list;

    }

}
