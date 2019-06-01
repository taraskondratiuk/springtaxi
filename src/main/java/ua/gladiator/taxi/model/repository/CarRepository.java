package ua.gladiator.taxi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
