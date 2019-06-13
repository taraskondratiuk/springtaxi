package ua.gladiator.taxi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Ride;
import java.util.List;

@Repository
public interface RideRepository extends CrudRepository<Ride, Integer> {
    List<Ride> findAllByClientId(Long id);


}
