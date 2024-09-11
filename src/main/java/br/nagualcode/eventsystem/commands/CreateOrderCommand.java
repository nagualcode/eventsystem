package br.nagualcode.eventsystem.commands;

public class CreateOrderCommand extends BaseCommand<String> {
    private final String description;
    private final double price;
    private final String customerId;

    public CreateOrderCommand(String id, String description, double price, String customerId) {
        super(id);
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
