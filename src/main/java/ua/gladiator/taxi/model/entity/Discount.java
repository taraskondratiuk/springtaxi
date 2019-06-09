package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddiscounts;


    @NotEmpty
    private Integer discount;

    private Long minSpentValue;

    private SocialStatus socialStatus;

    private Boolean specialDiscount;
}
