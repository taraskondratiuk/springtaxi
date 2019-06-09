package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Car;
import ua.gladiator.taxi.model.repository.CarRepository;
import ua.gladiator.taxi.model.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }
}
