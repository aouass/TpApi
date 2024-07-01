package com.TicketGes.TicketGes.Controller;

import com.TicketGes.TicketGes.Entity.TicketEntity;
import com.TicketGes.TicketGes.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class   TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketEntity> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public TicketEntity getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/creerticket")
    public TicketEntity createTicket(@RequestBody TicketEntity ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/modifier/{id}")
    public TicketEntity updateTicket(@PathVariable Long id, @RequestBody TicketEntity ticketDetails) {
        System.out.println("afficher un message");
        return ticketService.updateTicket(id, ticketDetails);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
