package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<BaseEntity, Long> {
}
