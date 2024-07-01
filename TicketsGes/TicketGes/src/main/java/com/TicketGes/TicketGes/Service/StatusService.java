package com.TicketGes.TicketGes.Service;


import com.TicketGes.TicketGes.Entity.StatusEntity;
import com.TicketGes.TicketGes.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;
    StatusRepository StatusRepository;
    public StatusService(StatusRepository StatusRepository, StatusRepository statusRepository) {
        this.StatusRepository = StatusRepository;
        this.statusRepository = statusRepository;
    }

    public List<StatusEntity> getAllStatus() {
        return StatusRepository.findAll();
    }

    public StatusEntity getStatusById(Long id) {
        return StatusRepository.findById(id).orElse(null);
    }

    public StatusEntity createStatus(StatusEntity status) {
        return StatusRepository.save(status);
    }

    public StatusEntity updateStatus(long id, StatusEntity nouveaustatus) {
        StatusEntity ancienstatus= this.getStatusById(id);
        if (ancienstatus != null) {
            nouveaustatus.setIdStatus(ancienstatus.getIdStatus());
            return statusRepository.save(nouveaustatus);
        }
        return null;
    }

    public void deleteStatus(Long id) {
        StatusRepository.deleteById(id);
    }
}
