package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Ride;

@Service
public interface RideService {
    void addRide(Ride ride);
    boolean isReady(Ride ride);
}
