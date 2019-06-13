package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.entity.RideDetailsDTO;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

import java.util.List;

@Service
public interface UtilityService {
    public List<RideDetailsDTO> getCarWithTimeList(CarType carType, Street destPlace);
    public Long countPrice(Integer discount, Long time);
    public List<RideDetailsDTO> buildListDetails(List<Ride> rides);

    void recountPersonalDiscount(Client client);
}
