package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.entity.RideDetails;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;
import ua.gladiator.taxi.model.repository.CarRepository;
import ua.gladiator.taxi.model.repository.TimeRepository;
import ua.gladiator.taxi.model.service.UtilityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilityServiceImpl implements UtilityService {

    private final TimeRepository timeRepository;
    private final CarRepository carRepository;

    public UtilityServiceImpl(TimeRepository timeRepository, CarRepository carRepository) {
        this.timeRepository = timeRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<RideDetails> getCarWithTimeList(CarType carType, Street destPlace) {
        List cars = carRepository.getAllByTypeAndIs_aviliable(carType);
        List<RideDetails> res = new ArrayList<>(cars.size());

        return null;
    }

    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public List<RideDetails> buildListDetails(List<Ride> rides) {
        List <RideDetails> list = new ArrayList<>();
        rides.forEach(v -> list.add(RideDetails
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
