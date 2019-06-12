package ua.gladiator.taxi.model.service;

/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.Client;
import java.util.List;

@Service
public interface ClientService extends UserDetailsService {
    List<Client> getAll();

    /*@Override
    UserDetails loadUserByUsername(String s);*/

    boolean isRegistered(String login);
    void registerClient(Client client);

    void addToSpentValue(Long value);
    Client getCurrentClient();
}
