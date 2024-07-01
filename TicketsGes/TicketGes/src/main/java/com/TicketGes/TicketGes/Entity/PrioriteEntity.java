package com.TicketGes.TicketGes.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="Priorite")
public class PrioriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriorite;
    private String niveau;

    @JsonIgnore
    @OneToMany(mappedBy = "priorite")
    List<TicketEntity> tickets;
}
