package ua.gladiator.taxi.model.entity;

import lombok.*;
import ua.gladiator.taxi.model.entity.enums.Street;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "rides")
@AllArgsConstructor
@Builder
public class Ride {
/*    public Ride() {
        this.car_id =(long)1;
        //this.clientId ="salhf";
        //this.initialPlace = Street.Brovary;
        this.time_id = 2L;
        this.price = (long) 12;
        this.waitTime = (long) 1488;

    }*/


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotNull
    private Long car_id;

    @NotNull
    private Long clientId;

    @NotNull
    private Long time_id;

    @NotNull
    private Long price;

    @NotNull
    private Long waitTime;
}
