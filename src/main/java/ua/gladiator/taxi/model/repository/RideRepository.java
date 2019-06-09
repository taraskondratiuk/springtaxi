package ua.gladiator.taxi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Ride;

@Repository
public interface RideRepository extends CrudRepository<Ride, Integer> {
}
