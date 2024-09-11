package br.nagualcode.eventsystem.controllers;

import br.nagualcode.eventsystem.models.Event;
import br.nagualcode.eventsystem.services.OrderEventQueryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class OrderCommandController {

    private final OrderEventQueryService eventQueryService;

    public OrderCommandController(OrderEventQueryService eventQueryService) {
        this.eventQueryService = eventQueryService;
    }

    // Endpoint para retornar todos os eventos
    @GetMapping
    public List<Event> getAllEvents() {
        return eventQueryService.getAllEvents();
    }

    // Endpoint para retornar eventos por ID de ordem
    @GetMapping("/{orderId}")
    public List<Event> getEventsByOrderId(@PathVariable String orderId) {
        return eventQueryService.getEventsByOrderId(orderId);
    }

    // Endpoint para retornar eventos por tipo
    @GetMapping("/type/{eventType}")
    public List<Event> getEventsByType(@PathVariable String eventType) {
        return eventQueryService.getEventsByType(eventType);
    }

    // Endpoint para retornar eventos dentro de um intervalo de tempo (opcional)
    @GetMapping("/date-range")
    public List<Event> getEventsByDateRange(@RequestParam("start") String startDateTime,
                                            @RequestParam("end") String endDateTime) {
        LocalDateTime start = LocalDateTime.parse(startDateTime);
        LocalDateTime end = LocalDateTime.parse(endDateTime);
        return eventQueryService.getEventsByDateRange(start, end);
    }
}
