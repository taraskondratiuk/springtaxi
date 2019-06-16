package ua.gladiator.taxi.controller;


/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;*/
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import ua.gladiator.taxi.model.entity.Client;
        import ua.gladiator.taxi.model.entity.enums.SocialStatus;
        import ua.gladiator.taxi.model.service.ClientService;

        import java.util.*;

@Controller
@RequestMapping(path = "/")
public class AccountController {

    private final ClientService clientService;

    public AccountController(ClientService clientService) {
        this.clientService = clientService;
    }


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =(User) authentication.getPrincipal();
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        System.out.println(user.getUsername());*/
        //System.out.println("+++++++++++++");
        //List<Car> list = carService.getAvailable(CarType.valueOf("BUS"));
        //System.out.println("----------------------------");
        //list.forEach(v -> System.out.println(v.getType()));/**/
        /*Car c = list.get(0);
        System.out.println("___________________________________");
        System.out.println(c.getType());
        System.out.println(c.getIdcars());
        System.out.println(c.getIs_aviliable());
        System.out.println(c.getMake());
        System.out.println(c.getPlace());*/

        return "index";
    }


    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                                     @RequestParam(value = "logout", required = false) String logout,
                                     Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);

        return "login";
    }





    /* // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String login,
                       @RequestParam String password,
                       @RequestParam String socialStatus,
                       @RequestParam BigDecimal totalSpentValue,
                       @RequestParam String role,
                       @RequestParam Integer personalDiscount
                       ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client n = new Client();
        n.setLogin(login);
        n.setPassword(password);
        n.setPersonalDiscount(personalDiscount);
        n.setSocialStatus(SocialStatus.valueOf(socialStatus));
        n.setTotalSpentValue(totalSpentValue);
        n.setRole(role);
        clientRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        // This returns a JSON or XML with the users
        return clientRepository.findAll();
    }*/
    @GetMapping("/register")
    public String registration(Map<String, Object> model) {
        model.put("statuses", SocialStatus.values());
        //System.out.println("registration");
        return "register";
    }

    @PostMapping("/register")
    public String addUser(Client client, Map<String, Object> model) {
        UserDetails userFromDb = clientService.loadUserByUsername(client.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "register";
        }

        clientService.registerClient(client);

        model.put("success_reg", "success_reg");
        return "index";
    }

}
