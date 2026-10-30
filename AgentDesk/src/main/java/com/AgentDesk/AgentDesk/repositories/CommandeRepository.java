package com.AgentDesk.AgentDesk.repositories;

import com.AgentDesk.AgentDesk.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
