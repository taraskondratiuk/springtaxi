package ua.gladiator.taxi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.gladiator.taxi.model.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
