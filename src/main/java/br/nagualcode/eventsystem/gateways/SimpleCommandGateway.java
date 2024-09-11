package br.nagualcode.eventsystem.gateways;

import br.nagualcode.eventsystem.commands.CreateOrderCommand;
import br.nagualcode.eventsystem.handlers.OrderCommandHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleCommandGateway implements CommandGateway {

    private final OrderCommandHandler orderCommandHandler;

    public SimpleCommandGateway(OrderCommandHandler orderCommandHandler) {
        this.orderCommandHandler = orderCommandHandler;
    }

    @Override
    public <T> void send(T command) {
        if (command instanceof CreateOrderCommand) {
            // Chama o manipulador de comando que utiliza o OrderCommandService
            orderCommandHandler.handleCreateOrderCommand((CreateOrderCommand) command);
        } else {
            throw new UnsupportedOperationException("Comando não suportado: " + command.getClass().getName());
        }
    }
}
