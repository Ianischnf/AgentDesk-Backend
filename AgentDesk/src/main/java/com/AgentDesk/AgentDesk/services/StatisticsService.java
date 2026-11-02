package com.AgentDesk.AgentDesk.services;

import com.AgentDesk.AgentDesk.dto.TotalOrdersByDayResponseDTO;
import com.AgentDesk.AgentDesk.dto.TotalOrdersResponseDTO;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import com.AgentDesk.AgentDesk.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<TotalOrdersByDayResponseDTO> countOrderDay(LocalDateTime debut, LocalDateTime fin){

        List<TotalOrdersByDayResponseDTO> statistiques = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            Long totalOrders = commandeRepository.countByCreatedAtGreaterThanEqualAndCreatedAtLessThan(debut, fin);
            LocalDate date = debut.toLocalDate();

            debut = debut.plusDays(1);
            fin = fin.plusDays(1);


            TotalOrdersByDayResponseDTO dto = new TotalOrdersByDayResponseDTO(
                    date,
                    totalOrders
            );

            statistiques.add(dto);
        }

        return statistiques;
    }
}
