package br.nagualcode.eventsystem.events;

public class OrderCreatedEvent extends BaseEvent<String> {
    private final String description;
    private final double price;
    private final String customerId;

    public OrderCreatedEvent(String id, String description, double price, String customerId) {
        super(id, "OrderCreatedEvent");
        this.description = description;
        this.price = price;
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCustomerId() {
        return customerId;
    }
}
