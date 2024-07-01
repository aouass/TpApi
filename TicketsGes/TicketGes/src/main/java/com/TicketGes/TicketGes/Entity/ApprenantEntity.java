package com.TicketGes.TicketGes.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)

@Table(name="Apprenant")
public class ApprenantEntity extends UserEntity {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @JsonIgnore
    @OneToMany(mappedBy = "apprenant")
    private List<NotificationEntity> notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "apprenant")
    private List<TicketEntity> tickets;
}


