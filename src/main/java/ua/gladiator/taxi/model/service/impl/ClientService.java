package ua.gladiator.taxi.model.service.impl;

import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import java.util.List;

@Service
public interface ClientService {
    List<Client> getAll();
    boolean isRegistered(String login);
    void registerClient(Client client);

}
