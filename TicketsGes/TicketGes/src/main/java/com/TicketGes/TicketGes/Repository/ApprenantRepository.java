package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.AdminEntity;
import com.TicketGes.TicketGes.Entity.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprenantRepository extends JpaRepository<ApprenantEntity, Long> {

    ApprenantEntity findByEmail(String email);
}
