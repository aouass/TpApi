package com.TicketGes.TicketGes.Entity;

import com.TicketGes.TicketGes.Controller.UserController;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Table(name = "user")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@EqualsAndHashCode(callSuper = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    //@Column(length = 50)
    private String firstname;
    //@Column(length = 50)
    private String nom;
    //@Column(length = 50)
    private String email;
    //@Column(length = 500)
    private String password;
    //@Column(length =60)
    private String username;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

}
