package com.TicketGes.TicketGes.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;
    private String message;
    private LocalDateTime dateNotification;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private ApprenantEntity apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private FormateurEntity formateur;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;

    @PrePersist
    protected void onCreate() {
        dateNotification = LocalDateTime.now();
    }

}
