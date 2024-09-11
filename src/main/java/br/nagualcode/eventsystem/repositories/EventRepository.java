package br.nagualcode.eventsystem.repositories;

import br.nagualcode.eventsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    List<Event> findAllById(String orderId);
}
