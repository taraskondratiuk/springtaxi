package ua.gladiator.taxi.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @NotEmpty
    Long id;

    @Id
    @NotEmpty
    Long ride_id;
}