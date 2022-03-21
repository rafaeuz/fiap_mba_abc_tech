package br.mba.fiap.abctech.abctechservice.service.impl;

import br.mba.fiap.abctech.abctechservice.model.Order;
import br.mba.fiap.abctech.abctechservice.repository.OrderRepository;
import br.mba.fiap.abctech.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl (@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        if (!order.hasMinAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (order.exceedsMaxAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrdersByOperator(Long operatorId) {
        return null;
    }
}
