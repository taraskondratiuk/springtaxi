package ua.gladiator.taxi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Car;
import ua.gladiator.taxi.model.entity.enums.CarType;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.type = :type AND c.is_aviliable = true")
    List<Car> getAllByTypeAndIs_aviliable(CarType type);

    Car getCarByIdcars(Long id);

    @Query("SELECT c.make from Car c WHERE c.idcars = :id ")
    String getMakeById(Long id);

    @Query("SELECT c.type from Car c WHERE c.idcars = :id ")
    CarType getTypeById(Long id);
}
