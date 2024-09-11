package br.nagualcode.eventsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    private String id;
    private String type;
    private LocalDateTime timestamp;
    private String eventData;

    public Event() {
        // Construtor padrão necessário para JPA
    }

    public Event(String id, String type, String eventData) {
        this.id = id;
        this.type = type;
        this.timestamp = LocalDateTime.now();
        this.eventData = eventData;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }
}
