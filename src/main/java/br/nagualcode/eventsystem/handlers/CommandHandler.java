package br.nagualcode.eventsystem.handlers;

import br.nagualcode.eventsystem.commands.CreateOrderCommand;
import br.nagualcode.eventsystem.events.OrderCreatedEvent;
import br.nagualcode.eventsystem.models.Event;
import br.nagualcode.eventsystem.models.Order;
import br.nagualcode.eventsystem.repositories.OrderRepository;
import br.nagualcode.eventsystem.repositories.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommandHandler {

    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;

    public CommandHandler(OrderRepository orderRepository, EventRepository eventRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }

    public void handle(CreateOrderCommand command) {
        try {
            // Gerar um ID único para a ordem
            String orderId = UUID.randomUUID().toString();

            // Criar e salvar a entidade Order
            Order order = new Order(orderId, command.getDescription(), command.getPrice(), command.getCustomerId());
            orderRepository.save(order);

            // Criar e converter o evento em JSON
            OrderCreatedEvent event = new OrderCreatedEvent(orderId, command.getDescription(), command.getPrice(), command.getCustomerId());
            String eventData = objectMapper.writeValueAsString(event);

            // Criar e salvar o evento no banco de dados
            Event eventEntity = new Event(orderId, event.getType(), eventData);
            eventRepository.save(eventEntity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao processar comando: " + e.getMessage());
        }
    }
}
