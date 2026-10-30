package com.AgentDesk.AgentDesk.entities;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomClient;
    private String description;
    private OrderStatut statut;
    private LocalDateTime createdAt;

    public Commande(String nomClient, String description, OrderStatut statut, LocalDateTime createdAt) {
        this.nomClient      = nomClient;
        this.description    = description;
        this.statut         = statut;
        this.createdAt      = createdAt;
    }

    public Commande(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatut getStatut() {
        return statut;
    }

    public void setStatut(OrderStatut statut) {
        this.statut = statut;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
