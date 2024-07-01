package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.ApprenantEntity;
import com.TicketGes.TicketGes.Entity.PrioriteEntity;
import com.TicketGes.TicketGes.Entity.UserEntity;
import com.TicketGes.TicketGes.Message.MessageResponse;
import com.TicketGes.TicketGes.Repository.ApprenantRepository;
import com.TicketGes.TicketGes.Repository.PrioriteRepository;
import com.TicketGes.TicketGes.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppenantService {
    private final ApprenantRepository apprenantRepository;
    ApprenantRepository ApprenantRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public AppenantService(ApprenantRepository ApprenantRepository, ApprenantRepository apprenantRepository,UserRepository userRepository) {
        this.ApprenantRepository = ApprenantRepository;
        this.apprenantRepository = apprenantRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<ApprenantEntity> getAllApprenant() {
        return ApprenantRepository.findAll();
    }

    public ApprenantEntity getApprenantById(Long id) {
        return ApprenantRepository.findById(id).orElse(null);
    }

    public Object createApprenant(ApprenantEntity apprenant) {
        UserEntity user = userRepository.findByUsername(apprenant.getUsername());
        String username = apprenant.getUsername();
        if (!userRepository.existsByUsername(username)){
            apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
            ApprenantRepository.save(apprenant);
            return new MessageResponse("Apprenant crée avec succès", true);
        }else {
            return new MessageResponse("Ce apprenant existe dejà", false);
        }
    }

    public ApprenantEntity updateApprenant(long id, ApprenantEntity nouveauapprenant) {
        ApprenantEntity ancienapprenant= this.getApprenantById(id);
        if (ancienapprenant != null) {
            nouveauapprenant.setIdUser(ancienapprenant.getIdUser());
            return apprenantRepository.save(nouveauapprenant);
        }
        return null;
    }

    public void deleteApprenant(Long id) {
        ApprenantRepository.deleteById(id);
    }
}
