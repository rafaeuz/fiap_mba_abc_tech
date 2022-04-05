package br.mba.fiap.abctech.abctechservice.application.impl;

import br.mba.fiap.abctech.abctechservice.application.OrderApplication;
import br.mba.fiap.abctech.abctechservice.application.dto.AssistDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderLocationDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderResponseDto;
import br.mba.fiap.abctech.abctechservice.model.Order;
import br.mba.fiap.abctech.abctechservice.model.OrderLocation;
import br.mba.fiap.abctech.abctechservice.repository.OrderRepository;
import br.mba.fiap.abctech.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class OrderApplicationImpl implements OrderApplication {

    private OrderService orderService;

    public OrderApplicationImpl(
            @Autowired
            OrderService orderService) {
        this.orderService = orderService;
    }


   public OrderResponseDto getOrder(Long id) {
        Order order = this.orderService.getOrderById(id);
        List<AssistDto> assistDtoList = order.getServices().stream().map(assistance -> new AssistDto(assistance.getId(), assistance.getName(), assistance.getDescription())).collect(Collectors.toList());
        OrderResponseDto orderDto = new OrderResponseDto(order.getId(), order.getOperatorId(),
                assistDtoList,
                this.getOrderLocationDtoFromOrderLocation(order.getStartOrderLocation()),
                this.getOrderLocationDtoFromOrderLocation(order.getEndOrderLocation()));
        return orderDto;
   }

    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEnd()));

        this.orderService.saveOrder (order, orderDto.getServices());
    }


    private OrderLocation getOrderLocationFromOrderLocationDto(OrderLocationDto orderLocationDto) {
        OrderLocation location = new OrderLocation();
        location.setLatitude(orderLocationDto.getLatitude());
        location.setLongitude(orderLocationDto.getLongitude());
        location.setDate(orderLocationDto.getDateTime());
        return location;
    }

    private OrderLocationDto getOrderLocationDtoFromOrderLocation(OrderLocation orderLocationDto) {
        OrderLocationDto location = new OrderLocationDto();
        location.setLatitude(orderLocationDto.getLatitude());
        location.setLongitude(orderLocationDto.getLongitude());
        location.setDateTime(orderLocationDto.getDate());
        return location;
    }

}
