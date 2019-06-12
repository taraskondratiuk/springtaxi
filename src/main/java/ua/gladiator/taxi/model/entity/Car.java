package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="cars")
public class Car {
    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcars;

    @NotEmpty
    private String make;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Street place;

    @NotEmpty
    private Boolean is_aviliable;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private CarType type;

    @Override
    public String toString() {
        return "" + idcars;
    }
}