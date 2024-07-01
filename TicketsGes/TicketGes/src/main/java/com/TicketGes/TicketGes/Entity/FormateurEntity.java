package com.TicketGes.TicketGes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="Formateur")
public class FormateurEntity extends UserEntity {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @JsonIgnore
    @OneToMany(mappedBy = "formateur")
    private List<NotificationEntity> notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "formateur")
    private List<TicketEntity> tickets;
}
