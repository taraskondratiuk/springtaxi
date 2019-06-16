package ua.gladiator.taxi.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ua.gladiator.taxi.model.entity.enums.CarType;



@Data
@Builder
@ToString
public class CarDetailsDTO {
    private Long id;

    private String carMake;

    private CarType carType;

    private Long numRides;

    private Long totalEarned;

    private Long totalTime;
}
