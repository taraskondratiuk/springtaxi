package ua.gladiator.taxi.model.entity;

import lombok.Builder;
import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

@Builder
@Data
public class ClientDetailsDTO {
    private String login;

    private SocialStatus socialStatus;

    private Long numRides;

    private Long totalSpentValue;

    private Long totalTime;

    private CarType mostCommonCarType;
}
