package br.nagualcode.eventsystem.services;

import br.nagualcode.eventsystem.models.Event;
import br.nagualcode.eventsystem.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderEventQueryService {

    private final EventRepository eventRepository;

    public OrderEventQueryService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Retorna todos os eventos de ordens
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Retorna eventos por ID de ordem
    public List<Event> getEventsByOrderId(String orderId) {
        return eventRepository.findAllById(orderId);
    }

    // Retorna eventos por tipo de evento
    public List<Event> getEventsByType(String eventType) {
        return eventRepository.findAll().stream()
                .filter(event -> event.getType().equals(eventType))
                .collect(Collectors.toList());
    }

    // Retorna eventos dentro de um intervalo de tempo
    public List<Event> getEventsByDateRange(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findAll().stream()
                .filter(event -> event.getTimestamp().isAfter(start) && event.getTimestamp().isBefore(end))
                .collect(Collectors.toList());
    }
}
