package ua.gladiator.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.repository.ClientRepository;
import ua.gladiator.taxi.model.service.impl.ClientService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public boolean isRegistered(String login) {
        return clientRepository.findByLogin(login) != null;
    }

    @Override
    public void registerClient(Client client) {
        client.setUserType("USER");
        clientRepository.save(client);
    }
//    @Override
//    public boolean isRegistered(String login) {
//
//        return clientRepository.numRegistered(login) != 0;
//    }
}
