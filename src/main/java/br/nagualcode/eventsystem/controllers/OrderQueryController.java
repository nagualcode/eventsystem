package br.nagualcode.eventsystem.controllers;

import br.nagualcode.eventsystem.models.Event;
import br.nagualcode.eventsystem.models.Order;
import br.nagualcode.eventsystem.services.OrderQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderById(@PathVariable String orderId) {
        return orderQueryService.getOrderById(orderId);
    }

    @GetMapping("/{orderId}/events")
    public List<Event> getOrderEvents(@PathVariable String orderId) {
        return orderQueryService.getOrderEvents(orderId);
    }
}
