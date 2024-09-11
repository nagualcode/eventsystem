package br.nagualcode.eventsystem.handlers;

import br.nagualcode.eventsystem.commands.CreateOrderCommand;
import br.nagualcode.eventsystem.events.OrderCreatedEvent;
import br.nagualcode.eventsystem.models.Order;
import br.nagualcode.eventsystem.repositories.OrderRepository;
import br.nagualcode.eventsystem.repositories.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderCommandHandler {

    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;

    public OrderCommandHandler(OrderRepository orderRepository, EventRepository eventRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }

    public void handleCreateOrderCommand(CreateOrderCommand command) {
        try {
            String orderId = command.getId();

            Order order = new Order(orderId, command.getDescription(), command.getPrice(), command.getCustomerId());
            orderRepository.save(order);

            OrderCreatedEvent event = new OrderCreatedEvent(orderId, command.getDescription(), command.getPrice(), command.getCustomerId());

            String eventData = objectMapper.writeValueAsString(event);
            br.nagualcode.eventsystem.models.Event eventEntity = new br.nagualcode.eventsystem.models.Event(orderId, event.getType(), eventData);
            eventRepository.save(eventEntity);


            applyEvent(event);
            
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao processar comando: " + e.getMessage());
        }
    }

    public void applyEvent(OrderCreatedEvent event) {

        System.out.println("Evento aplicado: " + event.getType() + " para o pedido ID: " + event.getId());

    }
}
