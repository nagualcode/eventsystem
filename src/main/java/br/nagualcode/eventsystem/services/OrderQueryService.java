package br.nagualcode.eventsystem.services;

import br.nagualcode.eventsystem.models.Event;
import br.nagualcode.eventsystem.models.Order;
import br.nagualcode.eventsystem.repositories.EventRepository;
import br.nagualcode.eventsystem.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;

    public OrderQueryService(OrderRepository orderRepository, EventRepository eventRepository) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
    }

    // Retorna todos os eventos de um pedido específico
    public List<Event> getOrderEvents(String orderId) {
        return eventRepository.findAll();
    }

    // Retorna a ordem pelo ID
    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }
}
