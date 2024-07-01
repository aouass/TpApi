package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.ReponseEntity;
import com.TicketGes.TicketGes.Repository.ReponseRepository;


import java.util.List;

public class ReponseService {
    ReponseRepository ReponseRepository ;

    public ReponseService(ReponseRepository ReponseRepository, ReponseRepository reponseRepository) {
        this.ReponseRepository = ReponseRepository;
    }

    public List<ReponseEntity> getAllReponse() {
        return ReponseRepository.findAll();
    }

    public ReponseEntity getReponseById(Long id) {
        return ReponseRepository.findById(id).orElse(null);
    }

    public ReponseEntity createReponse(ReponseEntity reponse) {
        return ReponseRepository.save(reponse);
    }

    public ReponseEntity updateReponse(long id, ReponseEntity nouveaureponse) {
        ReponseEntity ancienreponse= this.getReponseById(id);
        if (ancienreponse != null) {
            nouveaureponse.setIdReponse(ancienreponse.getIdReponse());
            return ReponseRepository.save(nouveaureponse);
        }
        return null;
    }

    public void deleteReponse(Long id) {
        ReponseRepository.deleteById(id);
    }
}
