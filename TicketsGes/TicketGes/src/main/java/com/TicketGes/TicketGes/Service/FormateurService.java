package com.TicketGes.TicketGes.Service;



import com.TicketGes.TicketGes.Entity.*;
import com.TicketGes.TicketGes.Message.MessageResponse;
import com.TicketGes.TicketGes.Repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormateurService {
    private final FormateurRepository formateurRepository;
    private final TicketRepository ticketRepository;
    private final StatusRepository statusRepository;
    private final ReponseRepository reponseRepository;
    FormateurRepository FormateurRepository;
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    EmailService emailService;

    /*public FormateurService(FormateurRepository FormateurRepository, FormateurRepository formateurRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.FormateurRepository = FormateurRepository;
        this.formateurRepository = formateurRepository;
        this.userRepository = userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
        this.ticketRepository = ticketRepository;
    }*/

    public List<FormateurEntity> getAllFormateur() {
        return FormateurRepository.findAll();
    }

    public FormateurEntity getFormateurById(Long id) {
        return FormateurRepository.findById(id).orElse(null);
    }

    public Object createFormateur(FormateurEntity formateur) {
        UserEntity user = userRepository.findByUsername(formateur.getUsername());
        String username = formateur.getUsername();
        if (!userRepository.existsByUsername(username)){
            formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
            FormateurRepository.save(formateur);
            return new MessageResponse("Formateur cree avec succes", true);
        }else {
            return new MessageResponse("Ce Formateur existe deja", false);
        }
    }

    public FormateurEntity updateFormateur(long id, FormateurEntity nouveauformateur) {
        FormateurEntity ancienformateur= this.getFormateurById(id);
        if (ancienformateur != null) {
            nouveauformateur.setIdUser(ancienformateur.getIdUser());
            return formateurRepository.save(nouveauformateur);
        }
        return null;
    }

    public void deleteFormateur(Long id) {
        FormateurRepository.deleteById(id);
    }

    public ReponseEntity repondreTicket(long id_tic, ReponseEntity reponse) {
        //return reponseRepository.save(reponse);
        ticketRepository.findById(id_tic)
                .map(T->{
                    //Optional<StatusEntity> S = statusRepository.findById(id_st);

        T.getStatus().setIdStatus(2);
        emailService.sendEmail(T.getApprenant().getEmail(), "Ticket repondu","votre ticket a été repondu");
                    ticketRepository.save(T);
                    reponse.setTicket(T);

                   //reponse.setFormateur(T.getFormateur());
                    return reponseRepository.save(reponse);
                }).orElseThrow(()-> new RuntimeException("Txghjh;,:"));
        return reponse;
    }



   /* public ResponseEntity<ReponseEntity> repondreTicket(long id_st, long id_tic, ReponseEntity reponse) {
        // Le type de retour doit être spécifié comme ResponseEntity<ReponseEntity>

        ticketRepository.findById(id_tic)
                .map(T -> {
                    Optional<StatusEntity> S = statusRepository.findById(id_st);
                    // Assurez-vous de vérifier si le StatusEntity est présent
                    if (S.isPresent()) {
                        T.setStatus(S.get());
                        emailService.sendEmail(T.getApprenant().getEmail(), "Ticket Created", "tyukl");
                        ticketRepository.save(T);
                        return reponseRepository.save(reponse);
                    } else {
                        throw new RuntimeException("Status not found");
                        // Ajoutez une exception si le status n'est pas trouvé
                    }
                }).orElseThrow(() -> new RuntimeException("Ticket not found"));
        // Ajoutez un return en dehors de la lambda pour retourner un ResponseEntity
        return null;
    }*/













        /*StatusEntity stat = ticket.getStatus();
        long stat_id = stat.getIdStatus();
        StatusEntity statFinded = this.statusService.getStatusById(stat_id);
        ticket.setStatus(statFinded);

        Optional<UserEntity> apprenant = userRepository.findById(ticket.getFormateur().getIdUser());
        String Text = apprenant.get().getUsername() + " vient de soumettre un ticket, le titre du ticket est :" +ticket.getTitre()+ ", la description est : "+ticket.getDescription();
        Optional<UserEntity> formateur = userRepository.findById(ticket.getFormateur().getIdUser());
        emailService.sendEmail(formateur.get().getEmail(), "Ticket Created", Text);
        //return ticketRepository.save(ticket);*/



    }
        /*Optional<TicketEntity> ticket= ticketRepository.findById(id);
        ticket.ifPresent(ticketEntity -> {ticketEntity.setReponse(reponse);
            UserEntity apprenant = ticket.get().getApprenant();
            UserEntity formateur = ticket.get().getFormateur();
            String email = apprenant.getEmail();
            String Text = formateur.getUsername() + " vient de repondre à votre ticket : la reponse est "+ticket.get().getReponse();
            emailService.sendEmail(email, "votre ticket a été repondu", Text);
        });
    return ticketRepository.save(ticket.get());
    }
}*/
