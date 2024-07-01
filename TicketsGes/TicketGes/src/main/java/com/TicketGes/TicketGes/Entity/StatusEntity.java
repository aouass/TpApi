package com.TicketGes.TicketGes.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="Status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatus;
    private String libellé;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    List<TicketEntity> tickets;
}
