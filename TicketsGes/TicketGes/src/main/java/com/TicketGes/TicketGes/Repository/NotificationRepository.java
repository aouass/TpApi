package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository  extends JpaRepository<NotificationEntity, Long> {

}
