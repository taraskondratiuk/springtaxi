package ua.gladiator.taxi.model.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.gladiator.taxi.model.entity.*;
import ua.gladiator.taxi.model.repository.CarRepository;
import ua.gladiator.taxi.model.repository.ClientRepository;
import ua.gladiator.taxi.model.repository.OrderRepository;
import ua.gladiator.taxi.model.repository.TimeRepository;
import ua.gladiator.taxi.model.service.UtilityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {

    private final TimeRepository timeRepository;
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;


    public UtilityServiceImpl(TimeRepository timeRepository, CarRepository carRepository, OrderRepository orderRepository, ClientRepository clientRepository) {
        this.timeRepository = timeRepository;
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public Page<OrderDetailsDTO> buildPageOrders(Pageable pageable, Client client) {
        final List <OrderDetailsDTO> list = new ArrayList<>();

        orderRepository.findAllByClientId(client.getId())
                .forEach(v -> list.add(OrderDetailsDTO
                .builder()
                .price(v.getPrice())
                .carMake(carRepository.getMakeById(v.getCar_id()))
                .carType(carRepository.getTypeById(v.getCar_id()))
                .destPlace(timeRepository.getDestById(v.getTime_id()))
                .initPlace(timeRepository.getInitById(v.getTime_id()))
                .time(timeRepository.getLongTimeById(v.getTime_id()))
        .build()));
        List<OrderDetailsDTO> resList = buildSubList(list, pageable);

        return new PageImpl<>(resList, pageable, list.size());


    }

    @Override
    public Page<CarDetailsDTO> buildPageCars(Pageable pageable) {
        final List <CarDetailsDTO> list = new ArrayList<>();
        carRepository.findAll().forEach(v -> list.add(CarDetailsDTO
                .builder()
                .carMake(v.getMake())
                .carType(v.getType())
                .id(v.getIdcars())
                .numRides(orderRepository.countAllByCar_id(v.getIdcars()))
                .totalEarned(orderRepository.countProfitByCarId(v.getIdcars()))
                .totalTime(orderRepository.countTimeByCarId(v.getIdcars()))
                .build()));
        List<CarDetailsDTO> resList = buildSubList(list, pageable);

        return new PageImpl<>(resList, pageable, list.size());
    }

    @Override
    public Page<ClientDetailsDTO> buildPageClients(Pageable pageable) {
        final List<ClientDetailsDTO> list = new ArrayList<>();
        clientRepository.fintUsers().forEach(v ->
                list.add(ClientDetailsDTO
                .builder()
                        .login(v.getLogin())
                        .mostCommonCarType(orderRepository.getMostCommonCarType(v.getId()))
                        .numRides(orderRepository.countAllByClientId(v.getId()))
                        .socialStatus(v.getSocialStatus())
                        .totalSpentValue(v.getTotalSpentValue())
                        .totalTime(orderRepository.countTimeByClientId(v.getId()))
                .build()));
        List<ClientDetailsDTO> resList = buildSubList(list, pageable);

        return new PageImpl<>(resList, pageable, list.size());
    }

    private List buildSubList(List list, Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int start = pageNumber * pageSize;
        if(start >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        int end = pageNumber * pageSize + pageSize > list.size() ?
                list.size() :
                pageNumber * pageSize + pageSize;
        return  list.subList(start, end);
    }

}
