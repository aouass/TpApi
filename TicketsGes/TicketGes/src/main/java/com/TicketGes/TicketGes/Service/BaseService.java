package com.TicketGes.TicketGes.Service;


import com.TicketGes.TicketGes.Entity.BaseEntity;
import com.TicketGes.TicketGes.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BaseService {
    private final BaseRepository baseRepository;
    //BaseRepository BaseRepository;
    public BaseService(BaseRepository BaseRepository, BaseRepository baseRepository) {
        //this.BaseRepository = BaseRepository;
        this.baseRepository = baseRepository;
    }

    public List<BaseEntity> getAllBase() {
        return baseRepository.findAll();
    }

    public BaseEntity getBaseById(Long id) {
        return baseRepository.findById(id).orElse(null);
    }

    public BaseEntity createBase(BaseEntity base) {
        return baseRepository.save(base);
    }

    public BaseEntity updateBase(long id, BaseEntity nouveaubase) {
        BaseEntity ancienbase= this.getBaseById(id);
        if (ancienbase != null) {
            nouveaubase.setId_base(ancienbase.getId_base());
            return baseRepository.save(nouveaubase);
        }
        return null;
    }

    public void deleteBase(Long id) {
        baseRepository.deleteById(id);
    }


}
