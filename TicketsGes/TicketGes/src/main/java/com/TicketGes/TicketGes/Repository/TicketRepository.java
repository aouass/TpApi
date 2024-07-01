package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.FormateurEntity;
import com.TicketGes.TicketGes.Entity.TicketEntity;
import com.TicketGes.TicketGes.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
