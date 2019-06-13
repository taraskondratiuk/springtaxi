package ua.gladiator.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.entity.Ride;
import ua.gladiator.taxi.model.entity.enums.CarType;
import ua.gladiator.taxi.model.entity.enums.Street;
import ua.gladiator.taxi.model.service.*;

import java.util.Map;
import java.util.List;

@Controller

@RequestMapping(path = "/user")
public class UserController {

    private final ClientService clientService;
    private final CarService carService;
    private final DiscountService discountService;
    private final TimeService timeService;
    private final RideService rideService;
    private final UtilityService utilityService;


    @Autowired
    public UserController(ClientService clientService, CarService carService, DiscountService discountService, TimeService timeService, RideService rideService, UtilityService utilityService) {
        this.clientService = clientService;
        this.carService = carService;
        this.discountService = discountService;
        this.timeService = timeService;
        this.rideService = rideService;
        this.utilityService = utilityService;
    }

    @GetMapping(path = "/home")
    public String showHome(Model model,
                           @RequestParam (value = "cancel", required = false) String cancel) {
        Client client = clientService.getCurrentClient();

        model.addAttribute("cancel", cancel != null);
        model.addAttribute("client", client);
        model.addAttribute("specialdiscount", discountService.getSpecialDiscount());
        model.addAttribute("numRides", rideService.getNumRides(client.getId()));
        return "userHome";
    }

    @GetMapping(path = "/order")
    public String showOrderPage(Map<String, Object> model) {

        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client user =(Client) authentication.getPrincipal();
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        System.out.println(user.getUsername());*/
        return "order";
    }

    @PostMapping(path = "/order")
    public String createRide(Map<String, Object> model,
                                   @RequestParam CarType carType,
                                   @RequestParam Street initPlace,
                                   @RequestParam Street destPlace,
                                   @RequestParam (required = false) Long carId) {
        model.put("cars", carService.getAvailableType(carType));
        model.put("initPlace", initPlace);
        model.put("destPlace", destPlace);
        model.put("carType", carType);
        if (carId != null) {
            model.put("waitTime", timeService.findLongTime(carService.getCarById(carId).getPlace(), initPlace));
            model.put("rideTime", timeService.findLongTime(initPlace, destPlace));
            model.put("timeId", timeService.findTime(initPlace, destPlace));
            model.put("price", utilityService.countPrice(
                    discountService.getClientDiscount(clientService.getCurrentClient()),
                    timeService.findLongTime(initPlace, destPlace)));
            model.put("car", carService.getCarById(carId));
        }
        return "order";
    }

    @ModelAttribute
    public void addAttributes(Map<String, Object> model) {
        model.put("discount", discountService.getClientDiscount(clientService.getCurrentClient()));
        model.put("types", CarType.values());
        model.put("streets", Street.values());
    }

    @PostMapping(path = "/history")
    public String confirmOrder(Map<String, Object> model,
                               @RequestParam Long carId,
                               @RequestParam Long timeId,
                               @RequestParam Long price,
                               @RequestParam Long waitTime) {

        rideService.addRide(Ride.builder()
                .car_id(carId)
                .clientId(clientService.getCurrentClient().getId())
                .price(price)
                .time_id(timeId)
                .waitTime(waitTime)
                .build());
        clientService.addToSpentValue(price);
        clientService.refreshDiscount(discountService.getClientDiscount(clientService.getCurrentClient()));


        model.put("success", "success");
        List <Ride> rides = rideService.getRidesByClientId(clientService.getCurrentClient().getId());
        model.put("details", utilityService.buildListDetails(rides));

        return "orderHistory";
    }

    @GetMapping(path = "/history")
    public String getOrderHistory(Map<String, Object> model) {
        List <Ride> rides = rideService.getRidesByClientId(clientService.getCurrentClient().getId());
        model.put("details", utilityService.buildListDetails(rides));

        return "orderHistory";
    }

    @GetMapping(path = "/changepw")
    public String getChangepwPage() {
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
}
