package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.Street;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rides")
public class Ride {
    public Ride() {
        //this.car_id =(long)1;
        this.clientLogin ="salhf";
        //this.initialPlace = Street.Brovary;
        //this.destinationPlace = Street.Svobody;
        this.price = (long) 12;
        this.time = (long) 1488;

    }


    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotEmpty
    private String car_id;

    @NotEmpty
    private String clientLogin;

    @NotEmpty
    private Long time_id;

    @NotEmpty
    private Long price;

    @NotEmpty
    private Long time;
}
