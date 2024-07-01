package com.TicketGes.TicketGes.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Base")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_base;

    private String questions;

    private String reponses;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private FormateurEntity formateur;

}
