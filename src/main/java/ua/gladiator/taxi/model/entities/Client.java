package ua.gladiator.taxi.model.entities;

import lombok.Data;

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
