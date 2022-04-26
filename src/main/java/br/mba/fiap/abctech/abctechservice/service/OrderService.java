package br.mba.fiap.abctech.abctechservice.service;

import br.mba.fiap.abctech.abctechservice.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> arrayAssists);
    Order getOrderById(Long orderId);
}
