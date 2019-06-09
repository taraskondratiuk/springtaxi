package ua.gladiator.taxi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.entity.enums.Role;
import ua.gladiator.taxi.model.repository.ClientRepository;
import ua.gladiator.taxi.model.service.ClientService;

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
    public UserDetails loadUserByUsername(String s) {

        UserDetails user= clientRepository.findByLogin(s);
        //System.out.println(user.getPassword());
        //System.out.println(user.getUsername());
        return user;
    }

    @Override
    public boolean isRegistered(String login) {
        return clientRepository.findByLogin(login) != null;
    }

    @Override
    public void registerClient(Client client) {
        client.setRole(Role.ROLE_USER);
        client.setTotalSpentValue(0L);
        client.setPersonalDiscount(0);
        clientRepository.save(client);
    }
//    @Override
//    public boolean isRegistered(String login) {
//
//        return clientRepository.numRegistered(login) != 0;
//    }
}
