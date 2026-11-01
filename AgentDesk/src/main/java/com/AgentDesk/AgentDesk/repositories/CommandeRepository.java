package com.AgentDesk.AgentDesk.repositories;

import com.AgentDesk.AgentDesk.entities.Commande;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    long countByStatut(OrderStatut statut);
}
