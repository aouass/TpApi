package com.TicketGes.TicketGes.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Categorie")
public class CategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id_categorie;
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<TicketEntity>tickets;
}
