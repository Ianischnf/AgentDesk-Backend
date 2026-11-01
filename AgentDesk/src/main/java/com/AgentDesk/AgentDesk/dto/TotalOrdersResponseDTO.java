package com.AgentDesk.AgentDesk.dto;

import com.AgentDesk.AgentDesk.enums.OrderStatut;

public record TotalOrdersResponseDTO(
        Long totalOrders,
        Long pendingOrders,
        Long preparingOrders,
        Long completedOrders
) {
}
