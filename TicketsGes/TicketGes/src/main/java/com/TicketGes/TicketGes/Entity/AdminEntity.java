package com.TicketGes.TicketGes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Admin")
public class AdminEntity extends UserEntity {

    @JsonIgnore
    @OneToMany(mappedBy = "admin")
    private List<ApprenantEntity> apprenants;

    @JsonIgnore
    @OneToMany(mappedBy = "admin")
    private List<FormateurEntity> formateurs;


}
