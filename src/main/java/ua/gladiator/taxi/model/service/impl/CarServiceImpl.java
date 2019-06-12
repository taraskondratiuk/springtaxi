package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Car;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.repository.CarRepository;
import ua.gladiator.taxi.model.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAvailable() {
        return getAll()
                .stream()
                .filter(Car::getIs_aviliable)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAvailableType(CarType type) {
        return carRepository.getAllByTypeAndIs_aviliable(type);
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car getCarById(Long carId) {
        return carRepository.getCarByIdcars(carId);
    }
}
