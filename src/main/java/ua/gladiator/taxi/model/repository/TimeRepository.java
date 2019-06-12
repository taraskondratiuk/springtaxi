package ua.gladiator.taxi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entity.Time;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {

    Time getTimeById(Long id);

    Time findAllByDestinationPlaceAndInitialPlace(Street initial_place, Street destination_place);

    @Query("SELECT t.destinationPlace from Time t WHERE t.id = :id ")
    Street getDestById(Long id);

    @Query("SELECT t.initialPlace from Time t WHERE t.id = :id ")
    Street getInitById(Long id);

    @Query("SELECT t.time from Time t WHERE t.id = :id ")
    Long getLongTimeById(Long id);
}
