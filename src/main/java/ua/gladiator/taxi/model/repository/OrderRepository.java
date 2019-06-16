package ua.gladiator.taxi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Order;
import ua.gladiator.taxi.model.entity.enums.CarType;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllByClientId(Long id);

    @Query("SELECT COUNT(o.id) FROM Order o WHERE o.car_id = :carId")
    Long countAllByCar_id(Long carId);

    @Query("SELECT SUM(x.price) FROM Order x WHERE x.car_id = :id")
    Long countProfitByCarId(Long id);


    @Query(value = "SELECT SUM(t.time)  FROM orders JOIN times t ON orders.time_id = t.id WHERE orders.car_id = :id",
    nativeQuery = true)
    Long countTimeByCarId(@Param("id") Long id);

    @Query(value = "SELECT cars.type FROM cars JOIN orders ON cars.idcars = orders.car_id WHERE orders.client_id = :clientId GROUP BY  cars.type ORDER BY COUNT(cars.type) DESC LIMIT 1",
    nativeQuery = true)
    CarType getMostCommonCarType(@Param("clientId") Long clientId);

    @Query("SELECT COUNT(o.id) FROM Order o WHERE o.clientId = :clientId")
    Long countAllByClientId(Long clientId);

    @Query(value = "SELECT SUM(t.time)  FROM orders JOIN times t ON orders.time_id = t.id WHERE orders.client_id = :id",
            nativeQuery = true)
    Long countTimeByClientId(@Param("id") Long id);

}
