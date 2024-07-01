package com.TicketGes.TicketGes.Service;


import com.TicketGes.TicketGes.Entity.RoleEntity;
import com.TicketGes.TicketGes.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    RoleRepository RoleRepository;

    public RoleService(RoleRepository RoleRepository, RoleRepository roleRepository) {
        this.RoleRepository = RoleRepository;
    }

    public List<RoleEntity> getAllRole() {
        return RoleRepository.findAll();
    }

    public RoleEntity getRoleById(Long id) {
        return RoleRepository.findById(id).orElse(null);
    }

    public RoleEntity createRole(RoleEntity role) {
        return RoleRepository.save(role);
    }

    public RoleEntity updateRole(long id, RoleEntity nouveaurole) {
        RoleEntity ancienrole= this.getRoleById(id);
        if (ancienrole != null) {
            nouveaurole.setIdRole(ancienrole.getIdRole());
            return RoleRepository.save(nouveaurole);
        }
        return null;
    }

    public void deleteRole(Long id) {
        RoleRepository.deleteById(id);
    }
}
