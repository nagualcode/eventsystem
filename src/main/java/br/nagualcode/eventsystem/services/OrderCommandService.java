package br.nagualcode.eventsystem.services;

import br.nagualcode.eventsystem.commands.CreateOrderCommand;
import br.nagualcode.eventsystem.gateways.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void createOrder(String description, double price, String customerId) {
        String orderId = UUID.randomUUID().toString();
        CreateOrderCommand command = new CreateOrderCommand(orderId, description, price, customerId);
        commandGateway.send(command);
    }
}
