package br.nagualcode.eventsystem.gateways;

public interface CommandGateway {
    <T> void send(T command);
}
