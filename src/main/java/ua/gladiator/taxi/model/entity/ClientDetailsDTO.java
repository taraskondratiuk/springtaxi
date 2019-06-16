package ua.gladiator.taxi.model.entity;

import lombok.Builder;
import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

@Builder
@Data
public class ClientDetailsDTO {
    String login;

    SocialStatus socialStatus;

    Long numRides;

    Long totalSpentValue;

    Long totalTime;

    CarType mostCommonCarType;
}
