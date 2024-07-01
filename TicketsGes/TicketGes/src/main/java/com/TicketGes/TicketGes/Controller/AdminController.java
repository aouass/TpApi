package com.TicketGes.TicketGes.Controller;


import com.TicketGes.TicketGes.Entity.AdminEntity;
import com.TicketGes.TicketGes.Entity.TicketEntity;
import com.TicketGes.TicketGes.Service.AdminService;
import com.TicketGes.TicketGes.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/listAdmin")
    public List<AdminEntity> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    @GetMapping("/afficherparid/{id}")
    public AdminEntity getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/ajouter")
    public Object createAdmin(@RequestBody AdminEntity admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/modifier/{id}")
    public AdminEntity updateAdmin(@PathVariable Long id, @RequestBody AdminEntity adminDetails) {
        return this.adminService.updateAdmin(id, adminDetails);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }


}
