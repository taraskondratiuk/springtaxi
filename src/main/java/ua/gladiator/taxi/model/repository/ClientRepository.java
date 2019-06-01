package ua.gladiator.taxi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gladiator.taxi.model.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {




    @Query("SELECT b FROM Client b WHERE b.login = :login")
    Client findByLogin(String login);


//    @Query("SELECT COUNT (b) FROM Client b WHERE b.login = :login AND b.password = :password")
//    Long numRegistered(@Param("login") String login, @Param("password") String password);
}
