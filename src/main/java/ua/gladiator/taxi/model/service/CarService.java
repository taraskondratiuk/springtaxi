package ua.gladiator.taxi.model.service;

import ua.gladiator.taxi.model.entity.Car;
import ua.gladiator.taxi.model.entity.enums.CarType;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    List<Car> getAvailable();

    List<Car> getAvailableType(CarType type);

    Car getCarById(Long carId);
}
