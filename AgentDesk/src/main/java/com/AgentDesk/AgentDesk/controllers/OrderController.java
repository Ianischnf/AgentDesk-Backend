package com.AgentDesk.AgentDesk.controllers;

import com.AgentDesk.AgentDesk.dto.OrderRequestDTO;
import com.AgentDesk.AgentDesk.dto.OrderResponseDTO;
import com.AgentDesk.AgentDesk.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return this.orderService.createOrder(orderRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> fetchAllOrders() {
        List<OrderResponseDTO> orders = orderService.fetchAllOrder();

        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public OrderResponseDTO updateOrder(@PathVariable Long id, @RequestBody OrderRequestDTO orderRequestDTO) {
        return this.orderService.updateOrder(id, orderRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.orderService.deleteOrder(id);
    }
}
