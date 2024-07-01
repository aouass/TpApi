package com.TicketGes.TicketGes.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="reponse")
public class ReponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;
    private String Reponse;
    private String dateEnvoi;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;


}
