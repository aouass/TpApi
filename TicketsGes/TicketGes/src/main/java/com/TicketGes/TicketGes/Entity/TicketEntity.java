package com.TicketGes.TicketGes.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;
    @Column(length = 50)
    private String titre;
    @Column(length = 200)
    private String description;
    @Column(length = 50)
    private Date creationDate = new Date();
    @Column(length = 50)
    private Date updateDate = new Date();
    private String reponse;


    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private ApprenantEntity apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private FormateurEntity formateur;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieEntity categorie;

    @ManyToOne
    @JoinColumn(name = "priorite_id")
    private PrioriteEntity priorite;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;




}
