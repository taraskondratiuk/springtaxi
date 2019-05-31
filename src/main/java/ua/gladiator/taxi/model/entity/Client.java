package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Client {
    @Id
    private String login;

    private String password;

    private SocialStatus socialStatus;

    private BigDecimal totalSpentValue;

    private String userType;

    private Integer personalDiscount;
}
