package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.enums.Street;

@Service
public interface TimeService {
    Long findTime(Street initialPlace, Street destinationPlace);

}
