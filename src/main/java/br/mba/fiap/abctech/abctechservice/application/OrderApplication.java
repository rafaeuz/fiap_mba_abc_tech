package br.mba.fiap.abctech.abctechservice.application;

import br.mba.fiap.abctech.abctechservice.application.dto.OrderDto;

public interface OrderApplication {
    void createOrder(OrderDto orderDto) throws Exception;
}
