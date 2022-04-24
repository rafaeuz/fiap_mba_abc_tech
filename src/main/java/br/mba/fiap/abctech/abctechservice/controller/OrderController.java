package br.mba.fiap.abctech.abctechservice.controller;

import br.mba.fiap.abctech.abctechservice.application.OrderApplication;
import br.mba.fiap.abctech.abctechservice.application.dto.AssistDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderDto;
import br.mba.fiap.abctech.abctechservice.application.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderApplication orderApplication;


    public OrderController(@Autowired OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @GetMapping()
    @RequestMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("id") Long id) {
        OrderResponseDto order = this.orderApplication.getOrder(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping()
    public ResponseEntity createOrder(
            @Valid
            @RequestBody
            OrderDto orderDto
    ) throws Exception {
        orderApplication.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }

}

