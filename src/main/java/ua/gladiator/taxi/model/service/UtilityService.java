package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.entity.RideDetails;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

import java.util.List;

@Service
public interface UtilityService {
    public List<RideDetails> getCarWithTimeList(CarType carType, Street destPlace);
    public Long countPrice(Integer discount, Long time);
    public List<RideDetails> buildListDetails(List<Ride> rides);
}
