package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.entity.RideDetailsDTO;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;
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
    private final DiscountRepository discountRepository;

    public UtilityServiceImpl(TimeRepository timeRepository, CarRepository carRepository, DiscountRepository discountRepository) {
        this.timeRepository = timeRepository;
        this.carRepository = carRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public List<RideDetailsDTO> getCarWithTimeList(CarType carType, Street destPlace) {
        List cars = carRepository.getAllByTypeAndIs_aviliable(carType);
        List<RideDetailsDTO> res = new ArrayList<>(cars.size());

        return null;
    }

    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public void recountPersonalDiscount(Client client) {
        client.setPersonalDiscount(
                discountRepository.getPersonalDiscount(client.getTotalSpentValue(), client.getSocialStatus().toString())
        );
    }

    @Override
    public List<RideDetailsDTO> buildListDetails(List<Ride> rides) {
        List <RideDetailsDTO> list = new ArrayList<>();
        rides.forEach(v -> list.add(RideDetailsDTO
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
