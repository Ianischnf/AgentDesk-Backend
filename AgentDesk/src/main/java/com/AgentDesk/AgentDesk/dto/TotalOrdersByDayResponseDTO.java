package com.AgentDesk.AgentDesk.dto;

import java.time.LocalDate;

public record TotalOrdersByDayResponseDTO(
        LocalDate date,
        Long totalOrders
) {
}
