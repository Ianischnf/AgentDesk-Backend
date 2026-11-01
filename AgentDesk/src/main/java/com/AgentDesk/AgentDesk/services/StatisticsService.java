package com.AgentDesk.AgentDesk.services;

import com.AgentDesk.AgentDesk.dto.TotalOrdersResponseDTO;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import com.AgentDesk.AgentDesk.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final CommandeRepository commandeRepository;

    public StatisticsService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public Long totalOrder(){
        Long nbOrder = commandeRepository.count();

        return nbOrder;
    }

    public Long countOrderStatut(OrderStatut statut){
        return commandeRepository.countByStatut(statut);
    }

    public TotalOrdersResponseDTO getStatistics() {
        long totalOrder = totalOrder();
        long pending = countOrderStatut(OrderStatut.EN_ATTENTE);
        long preparing = countOrderStatut(OrderStatut.EN_PREPARATION);
        long completed = countOrderStatut(OrderStatut.TERMINEE);

        return new TotalOrdersResponseDTO(
                totalOrder,
                pending,
                preparing,
                completed
        );
    }
}
