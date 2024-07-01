package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.CategorieEntity;
import com.TicketGes.TicketGes.Entity.PrioriteEntity;
import com.TicketGes.TicketGes.Repository.CategorieRepository;
import com.TicketGes.TicketGes.Repository.PrioriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioriteService {
   private final PrioriteRepository prioriteRepository;
   PrioriteRepository PrioriteRepository;
    public PrioriteService(PrioriteRepository PrioriteRepository, PrioriteRepository prioriteRepository) {
        this.PrioriteRepository = PrioriteRepository;
        this.prioriteRepository = prioriteRepository;
    }

    public List<PrioriteEntity> getAllPriorite() {
        return PrioriteRepository.findAll();
    }

    public PrioriteEntity getPrioriteById(Long id) {
        return PrioriteRepository.findById(id).orElse(null);
    }

    public PrioriteEntity createPriorite(PrioriteEntity priorite) {
        return PrioriteRepository.save(priorite);
    }

    public PrioriteEntity updatePriorite(long id, PrioriteEntity nouveaupriorite) {
        PrioriteEntity ancienpriorite= this.getPrioriteById(id);
        if (ancienpriorite != null) {
            nouveaupriorite.setIdPriorite(ancienpriorite.getIdPriorite());
            return prioriteRepository.save(nouveaupriorite);
        }
        return null;
    }

    public void deletePriorite(Long id) {
        PrioriteRepository.deleteById(id);
    }
}
