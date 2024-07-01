package com.TicketGes.TicketGes.Controller;

import com.TicketGes.TicketGes.Entity.FormateurEntity;
import com.TicketGes.TicketGes.Entity.RoleEntity;
import com.TicketGes.TicketGes.Service.FormateurService;
import com.TicketGes.TicketGes.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleEntity> getAllRole() {
        return roleService.getAllRole();
    }

    @GetMapping("/{id}")
    public RoleEntity getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/create")
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRole(@PathVariable Long id, @RequestBody RoleEntity roleDetails) {
        return this.roleService.updateRole(id, roleDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
