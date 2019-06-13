package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Ride;
import java.util.List;


@Service
public interface RideService {
    void addRide(Ride ride);
    boolean isReady(Ride ride);
    List <Ride> getRidesByClientId(Long id);
    Integer getNumRides (Long id);
}
