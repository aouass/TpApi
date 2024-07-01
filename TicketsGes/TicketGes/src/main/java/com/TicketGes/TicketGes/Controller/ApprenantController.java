package com.TicketGes.TicketGes.Controller;


import com.TicketGes.TicketGes.Entity.ApprenantEntity;
import com.TicketGes.TicketGes.Entity.TicketEntity;
import com.TicketGes.TicketGes.Service.AppenantService;
import com.TicketGes.TicketGes.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenant")
public class ApprenantController {

    @Autowired
    private AppenantService appenantService;
    private TicketService ticketService;

    @GetMapping("/afficher")
    public List<ApprenantEntity> getAllApprenant() {
        return appenantService.getAllApprenant();
    }

    @GetMapping("/afficherparid/{id}")
    public ApprenantEntity getApprenantById(@PathVariable Long id) {
        return appenantService.getApprenantById(id);
    }

    @PostMapping("/creerApprenant")
    public Object createApprenant(@RequestBody ApprenantEntity apprenant) {
        return appenantService.createApprenant(apprenant);
    }

    @PutMapping("/modifierparid/{id}")
    public ApprenantEntity updateApprenant(@PathVariable Long id, @RequestBody ApprenantEntity apprenantDetails) {
        return this.appenantService.updateApprenant(id, apprenantDetails);
    }

    @DeleteMapping("/supprimerparid/{id}")
    public void deleteApprenant(@PathVariable Long id) {
        appenantService.deleteApprenant(id);
    }

    @PostMapping("/creerTicket")
    public TicketEntity createTicket(@RequestBody TicketEntity ticket) {

        return ticketService.createTicket(ticket);
    }

}








/*

@Autowired
private AppenantService appenantService;
private TicketService ticketService;

@GetMapping
public List<ApprenantEntity> getAllApprenant() {
    return appenantService.getAllApprenant();
}

@GetMapping("/{id}")
public ApprenantEntity getApprenantById(@PathVariable Long id) {
    return appenantService.getApprenantById(id);
}

@PostMapping
public ApprenantEntity createApprenant(@RequestBody ApprenantEntity apprenant) {
    return appenantService.createApprenant(apprenant);
}

@PutMapping("/{id}")
public ApprenantEntity updateApprenant(@PathVariable Long id, @RequestBody ApprenantEntity apprenantDetails) {
    return this.appenantService.updateApprenant(id, apprenantDetails);
}

@DeleteMapping("/{id}")
public void deleteApprenant(@PathVariable Long id) {
    appenantService.deleteApprenant(id);
}


*/
