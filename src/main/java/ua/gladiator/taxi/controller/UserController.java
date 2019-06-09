package ua.gladiator.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.gladiator.taxi.model.entity.enums.Street;
import ua.gladiator.taxi.model.service.CarService;
import ua.gladiator.taxi.model.service.ClientService;
import ua.gladiator.taxi.model.service.DiscountService;
import ua.gladiator.taxi.model.service.TimeService;

@Controller

@RequestMapping(path = "/user")
public class UserController {

    private final ClientService clientService;
    private final CarService carService;
    private final DiscountService discountService;
    private final TimeService timeService;


    @Autowired
    public UserController(ClientService clientService, CarService carService, DiscountService discountService, TimeService timeService) {
        this.clientService = clientService;
        this.carService = carService;
        this.discountService = discountService;
        this.timeService = timeService;
    }

    @GetMapping(path = "/home")
    public ModelAndView showMain() {


        return new ModelAndView("userHome") ;
    }

    @GetMapping(path = "/order")
    public String showOrderPage() {
        return "order";
    }






}
