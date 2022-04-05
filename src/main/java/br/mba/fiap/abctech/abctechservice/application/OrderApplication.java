package br.mba.fiap.abctech.abctechservice.application;

import br.mba.fiap.abctech.abctechservice.application.dto.OrderDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderResponseDto;

public interface OrderApplication {

    public OrderResponseDto getOrder(Long id);
    public void createOrder(OrderDto orderDto);
}
