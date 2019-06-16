package ua.gladiator.taxi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.service.ClientService;
import ua.gladiator.taxi.model.service.UtilityService;

import java.util.Map;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private final ClientService clientService;
    private final UtilityService utilityService;

    public AdminController(ClientService clientService, UtilityService utilityService) {
        this.clientService = clientService;
        this.utilityService = utilityService;
    }

    @ModelAttribute
    public void addAttributes(Map<String, Object> model) {
        model.put("role", "admin");
    }


    @GetMapping(path = "/home")
    String getAdminHome(Map<String, Object> model) {

        model.put("client", clientService.getCurrentClient());
        return "adminHome";
    }

    @GetMapping(path = "/changepw")
    public String getChangePwPage() {
        return "changePassword";
    }

    @PostMapping(path = "/changepw")
    public String changePw(Map<String, Object> model,
                           @RequestParam String oldpassword,
                           @RequestParam String newpassword) {
        Client client = clientService.getCurrentClient();

        if (!client.getPassword().equals(oldpassword)) {
            model.put("error", "error");
            return "changePassword";
        }
        clientService.changePassword(oldpassword, newpassword, client.getId());
        model.put("pwchanged", "pwchanged");
        return "changePassword";

    }

    @GetMapping(path = "/cars")
    public String getCars(Map<String, Object> model,
                          @PageableDefault(size = 7) Pageable page) {

        model.put("page", utilityService.buildPageCars(page));

        model.put("url", "/admin/cars");
        return "cars";
    }

    @GetMapping(path = "/clients")
    public String getClients(Map<String, Object> model,
                             @PageableDefault(size = 7) Pageable page) {
        model.put("page", utilityService.buildPageClients(page));

        model.put("url", "/admin/clients");
        return "clients";
    }
}
