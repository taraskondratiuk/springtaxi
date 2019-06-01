package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Entity
public class Client {
    @Id
    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String socialStatus;

    private BigDecimal totalSpentValue;

    private String userType;

    private Integer personalDiscount;
}
