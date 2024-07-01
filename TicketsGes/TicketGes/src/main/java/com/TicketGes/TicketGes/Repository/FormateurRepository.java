package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.AdminEntity;
import com.TicketGes.TicketGes.Entity.FormateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormateurRepository  extends JpaRepository<FormateurEntity, Long> {

    FormateurEntity findByEmail(String email);
}
