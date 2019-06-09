package ua.gladiator.taxi.model.entity;

import lombok.Data;
import ua.gladiator.taxi.model.entity.enums.Street;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "times")
public class Time {

    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private Street initialPlace;

    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private Street destinationPlace;

    @NotEmpty
    private Long price;

    @NotEmpty
    private Long time;
}
