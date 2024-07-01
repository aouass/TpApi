package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.AdminEntity;
import com.TicketGes.TicketGes.Entity.UserEntity;
import com.TicketGes.TicketGes.Message.MessageResponse;
import com.TicketGes.TicketGes.Repository.AdminRepository;
import com.TicketGes.TicketGes.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdminService {
    private final AdminRepository adminRepository;
    AdminRepository AdminRepository;
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public AdminService(AdminRepository AdminRepository, AdminRepository adminRepository, UserRepository userRepository) {
        this.AdminRepository = AdminRepository;
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public List<AdminEntity> getAllAdmin() {
        return AdminRepository.findAll();
    }

    public AdminEntity getAdminById(Long id) {
        return AdminRepository.findById(id).orElse(null);
    }

    public Object createAdmin(AdminEntity admin) {
        UserEntity user = userRepository.findByUsername(admin.getUsername());
        String username = admin.getUsername();
        if (!userRepository.existsByUsername(username)){
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            AdminRepository.save(admin);
            return new MessageResponse("Admin cree avec succes", true);
        }else {
            return new MessageResponse("Cet username existe deja", false);
        }
    }


    public AdminEntity updateAdmin(long id, AdminEntity nouveauadmin) {
        AdminEntity ancienadmin= this.getAdminById(id);
        if (ancienadmin != null) {
            nouveauadmin.setIdUser(ancienadmin.getIdUser());
            return adminRepository.save(nouveauadmin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }


}
