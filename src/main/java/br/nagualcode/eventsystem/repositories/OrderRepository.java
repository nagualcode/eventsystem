package br.nagualcode.eventsystem.repositories;

import br.nagualcode.eventsystem.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
