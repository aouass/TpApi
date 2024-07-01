package com.TicketGes.TicketGes.Repository;

import com.TicketGes.TicketGes.Entity.RoleEntity;
import com.TicketGes.TicketGes.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
   @Query("select u.role.nomRole from UserEntity u where u.username=:x")
   UserEntity findRoleByUsername(@Param("x") String username);

   UserEntity findByUsername(String username);

   boolean existsByUsername(String username);

}
