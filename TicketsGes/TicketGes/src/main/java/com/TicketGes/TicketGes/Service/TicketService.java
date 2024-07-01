package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.*;
import com.TicketGes.TicketGes.Repository.TicketRepository;
import com.TicketGes.TicketGes.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private PrioriteService prioriteService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public List<TicketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    public TicketEntity getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public TicketEntity createTicket(TicketEntity ticket) {
        CategorieEntity cate = ticket.getCategorie();
        long cate_id = cate.getId_categorie();
        CategorieEntity cateFinded = this.categorieService.getCategorieById(cate_id);
        ticket.setCategorie(cateFinded);

        PrioriteEntity prio = ticket.getPriorite();
        long prio_id = prio.getIdPriorite();
        PrioriteEntity prioFinded = this.prioriteService.getPrioriteById(prio_id);
        ticket.setPriorite(prioFinded);

        StatusEntity stat = ticket.getStatus();
        long stat_id = stat.getIdStatus();
        StatusEntity statFinded = this.statusService.getStatusById(stat_id);
        ticket.setStatus(statFinded);

        Optional<UserEntity> apprenant = userRepository.findById(ticket.getFormateur().getIdUser());
        String Text = apprenant.get().getUsername() + " vient de soumettre un ticket, le titre du ticket est :" +ticket.getTitre()+ ", la description est : "+ticket.getDescription();
        Optional<UserEntity> formateur = userRepository.findById(ticket.getFormateur().getIdUser());
        emailService.sendEmail(formateur.get().getEmail(), "Ticket Created", Text);
        return ticketRepository.save(ticket);
    }

    public TicketEntity updateTicket(long id, TicketEntity nouveauticket) {
        TicketEntity ancienticket= this.getTicketById(id);
        if (ancienticket != null) {
            nouveauticket.setId_ticket(ancienticket.getId_ticket());
            return ticketRepository.save(nouveauticket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
