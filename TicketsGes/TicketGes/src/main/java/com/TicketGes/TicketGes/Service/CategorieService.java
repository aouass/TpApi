package com.TicketGes.TicketGes.Service;

import com.TicketGes.TicketGes.Entity.CategorieEntity;
import com.TicketGes.TicketGes.Entity.TicketEntity;
import com.TicketGes.TicketGes.Repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;
    CategorieRepository CategorieRepository;
    public CategorieService(CategorieRepository CategorieRepository, CategorieRepository categorieRepository) {
        this.CategorieRepository = CategorieRepository;
        this.categorieRepository = categorieRepository;
    }

    public List<CategorieEntity> getAllCategorie() {
        return CategorieRepository.findAll();
    }

    public CategorieEntity getCategorieById(Long id) {
        return CategorieRepository.findById(id).orElse(null);
    }

    public CategorieEntity createCategorie(CategorieEntity categorie) {
        return CategorieRepository.save(categorie);
    }

    public CategorieEntity updateCategorie(long id, CategorieEntity nouveaucategorie) {
        CategorieEntity anciencategorie= this.getCategorieById(id);
        if (anciencategorie != null) {
            nouveaucategorie.setId_categorie(anciencategorie.getId_categorie());
            return categorieRepository.save(nouveaucategorie);
        }
        return null;
    }

    public void deleteCategorie(Long id) {
        CategorieRepository.deleteById(id);
    }
}
