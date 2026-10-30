package com.AgentDesk.AgentDesk.dto;

import com.AgentDesk.AgentDesk.enums.OrderStatut;

import java.time.LocalDateTime;

public record OrderRequestDTO(
        String nomClient,
        String description
) {
}
