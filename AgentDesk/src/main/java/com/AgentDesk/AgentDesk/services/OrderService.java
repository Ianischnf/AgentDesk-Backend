package com.AgentDesk.AgentDesk.services;

import com.AgentDesk.AgentDesk.dto.OrderRequestDTO;
import com.AgentDesk.AgentDesk.dto.OrderResponseDTO;
import com.AgentDesk.AgentDesk.entities.Commande;
import com.AgentDesk.AgentDesk.enums.OrderStatut;
import com.AgentDesk.AgentDesk.repositories.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final CommandeRepository commandeRepository;

    public OrderService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO CommandeDTO) {
        Commande newOrder = new Commande();

        newOrder.setNomClient(CommandeDTO.nomClient());
        newOrder.setDescription(CommandeDTO.description());
        newOrder.setStatut(OrderStatut.EN_ATTENTE);
        newOrder.setCreatedAt(LocalDateTime.now());

        Commande saveOrder = commandeRepository.save(newOrder);

        return new OrderResponseDTO(
                saveOrder.getId(),
                saveOrder.getNomClient(),
                saveOrder.getDescription(),
                saveOrder.getStatut(),
                saveOrder.getCreatedAt()
        );

    }

    public List<OrderResponseDTO> fetchAllOrder() {
        List<Commande> ListOrder = commandeRepository.findAll();

        List<OrderResponseDTO> TransformToDTO = ListOrder.stream()
                .map(o -> new OrderResponseDTO(
                        o.getId(),
                        o.getNomClient(),
                        o.getDescription(),
                        o.getStatut(),
                        o.getCreatedAt()
                )).toList();

        return TransformToDTO;
    }

    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO OrderUpdated) {
        Commande ExistingOrder = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        ExistingOrder.setNomClient(OrderUpdated.nomClient());
        ExistingOrder.setDescription(OrderUpdated.description());
       // ExistingOrder.setStatut(OrderUpdated.statut());

        commandeRepository.save(ExistingOrder);

        return new OrderResponseDTO(
                ExistingOrder.getId(),
                ExistingOrder.getNomClient(),
                ExistingOrder.getDescription(),
                ExistingOrder.getStatut(),
                ExistingOrder.getCreatedAt()
        );
    }

    public void deleteOrder(Long id) {
        Commande orderToDelete = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        commandeRepository.delete(orderToDelete);
    }

}
