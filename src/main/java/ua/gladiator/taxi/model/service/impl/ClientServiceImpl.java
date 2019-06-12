package ua.gladiator.taxi.model.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getCurrentClient() {
        return (Client) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public UserDetails loadUserByUsername(String s) {

        UserDetails user = clientRepository.findByLogin(s);

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

    @Override
    public void addToSpentValue(Long value) {
        Client client = getCurrentClient();
        client.setTotalSpentValue(client.getTotalSpentValue() + value);
    }

}
