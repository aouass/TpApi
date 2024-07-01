package com.TicketGes.TicketGes.Controller;



import com.TicketGes.TicketGes.Entity.FormateurEntity;
import com.TicketGes.TicketGes.Entity.ReponseEntity;
import com.TicketGes.TicketGes.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateur")

public class FormateurController {

    @Autowired
    private FormateurService formateurService;

    @GetMapping("/afficher")
    public List<FormateurEntity> getAllFormateur() {
        return formateurService.getAllFormateur();
    }

    @GetMapping("/afficherparid/{id}")
    public FormateurEntity getFormateurById(@PathVariable Long id) {
        return formateurService.getFormateurById(id);
    }

    @PostMapping("/create")
    public Object createFormateur(@RequestBody FormateurEntity formateur) {
        return formateurService.createFormateur(formateur);
    }

    //@PreAuthorize("hasRole("formateur")")
    @PostMapping("/reponseticket/{id_tic}")
    private Object repondreTicket(@RequestBody ReponseEntity reponseticket, @PathVariable Long id_tic) {
        return formateurService.repondreTicket(id_tic,reponseticket);
    }

    @PutMapping("/modifier/{id}")
    public FormateurEntity updateFormateur(@PathVariable Long id, @RequestBody FormateurEntity formateurDetails) {
        return this.formateurService.updateFormateur(id, formateurDetails);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteFormateur(@PathVariable Long id) {
        formateurService.deleteFormateur(id);
    }

}
