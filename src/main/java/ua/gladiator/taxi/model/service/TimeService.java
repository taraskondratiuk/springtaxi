package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Time;
import ua.gladiator.taxi.model.entity.enums.Street;

@Service
public interface TimeService {
    Long findLongTime(Street initialPlace, Street destinationPlace);

    Time findTime(Street initialPlace, Street destinationPlace);

    Time getTimeById(Long id);
}
