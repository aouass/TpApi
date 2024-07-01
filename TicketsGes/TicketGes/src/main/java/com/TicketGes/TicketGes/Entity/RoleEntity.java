package com.TicketGes.TicketGes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="Role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long idRole;
    private   String nomRole;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<UserEntity> users;

}
