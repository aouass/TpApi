package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository  extends JpaRepository<AdminEntity, Long> {


    AdminEntity findByEmail(String email);

}
