package com.AgentDesk.AgentDesk.dto;

import com.AgentDesk.AgentDesk.enums.OrderStatut;

import java.time.LocalDateTime;

public record OrderResponseDTO(
        int id,
        String nomClient,
        String description,
        OrderStatut statut,
        LocalDateTime createdAt
) {
}
