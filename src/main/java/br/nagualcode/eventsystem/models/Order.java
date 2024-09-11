package br.nagualcode.eventsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private String id;
    private String description;
    private double price;
    private String customerId;

    public Order() {
      
    }

    public Order(String id, String description, double price, String customerId) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.customerId = customerId;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
