package ua.gladiator.taxi.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

import javax.persistence.Entity;

@Data
@Builder
@ToString
public class OrderDetailsDTO {
    private String carMake;

    private Long price;

    private Long time;

    private Street initPlace;

    private Street destPlace;

    private CarType carType;
}
