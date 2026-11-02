package com.AgentDesk.AgentDesk.repositories;

import com.AgentDesk.AgentDesk.entities.Order;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CommandeRepository extends JpaRepository<Order, Long> {
    long countByStatut(OrderStatut statut);
    long countByCreatedAtGreaterThanEqualAndCreatedAtLessThan(
            LocalDateTime debut,
            LocalDateTime fin
    );
}
