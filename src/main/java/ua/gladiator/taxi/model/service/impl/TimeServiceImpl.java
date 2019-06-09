package ua.gladiator.taxi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.enums.Street;
import ua.gladiator.taxi.model.repository.TimeRepository;
import ua.gladiator.taxi.model.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Long findTime(Street initialPlace, Street destinationPlace) {
        return timeRepository.findAllByDestinationPlaceAndInitialPlace(initialPlace, destinationPlace).getTime();
    }
}
