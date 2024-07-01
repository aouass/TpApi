package com.TicketGes.TicketGes;

import com.TicketGes.TicketGes.Entity.AdminEntity;
import com.TicketGes.TicketGes.Entity.RoleEntity;
import com.TicketGes.TicketGes.Service.AdminService;
import com.TicketGes.TicketGes.Service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketGesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketGesApplication.class, args);
		/**AdminService adminService = ctx.getBean(AdminService.class);
		RoleService roleService = ctx.getBean(RoleService.class);

		RoleEntity role = new RoleEntity();
		role.setNomRole("ADMIN");
		role = roleService.createRole(role);

		AdminEntity admin = new AdminEntity();
		admin.setPassword("1234");
		admin.setEmail("sowaoua204@gmail.com");
		admin.setFirstname("Aoua");
		admin.setNom("Sow");
		admin.setUsername("SOW");
		admin.setRole(role);

		adminService.createAdmin(admin);**/


	}

}
