package ua.gladiator.taxi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Time;
import ua.gladiator.taxi.model.entity.enums.Street;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {


    Time findAllByDestinationPlaceAndInitialPlace(Street initial_place, Street destination_place);
}
