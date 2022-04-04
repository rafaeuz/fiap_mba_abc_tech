package br.mba.fiap.abctech.abctechservice.service.impl;

import br.mba.fiap.abctech.abctechservice.model.Assistance;
import br.mba.fiap.abctech.abctechservice.model.Order;
import br.mba.fiap.abctech.abctechservice.repository.AssistanceRepository;
import br.mba.fiap.abctech.abctechservice.repository.OrderRepository;
import br.mba.fiap.abctech.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private AssistanceRepository assistanceRepository;

    public OrderServiceImpl (@Autowired OrderRepository orderRepository,
                             @Autowired AssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists)  {
        ArrayList<Assistance> assistances = new ArrayList<>();

        arrayAssists.forEach( i ->{
            Assistance assistance = this.assistanceRepository.findById(i).orElseThrow();
            assistances.add(assistance);
        });

        order.setServices(assistances);

        if (!order.hasMinAssists()){
            throw new ArrayIndexOutOfBoundsException();
        } else if (order.exceedsMaxAssists()){
            throw new ArrayIndexOutOfBoundsException();
        }

        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrdersByOperator(Long operatorId) {
        return null;
    }
}