package ua.gladiator.taxi.model.service;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import java.util.List;

@Service
public interface ClientService {
    List<Client> getAll();
    boolean isRegistered(String name, String password);
}
