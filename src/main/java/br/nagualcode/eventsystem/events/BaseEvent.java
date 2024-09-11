package br.nagualcode.eventsystem.events;

public abstract class BaseEvent<T> {
    private final T id;
    private final String type;

    protected BaseEvent(T id, String type) {
        this.id = id;
        this.type = type;
    }

    public T getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
