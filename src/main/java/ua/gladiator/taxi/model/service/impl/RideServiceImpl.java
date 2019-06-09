package ua.gladiator.taxi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.repository.RideRepository;
import ua.gladiator.taxi.model.service.RideService;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    public RideServiceImpl(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public boolean isReady(Ride ride) {
        return  ride.getClientLogin() != null &&
                ride.getCar_id() != null &&
                ride.getTime_id() != null &&
                ride.getPrice() != null &&
                ride.getTime() != null;
    }

    @Override
    public void addRide(Ride ride) {
        rideRepository.save(ride);
    }
}
