package com.TicketGes.TicketGes.Controller;


import com.TicketGes.TicketGes.Entity.PrioriteEntity;
import com.TicketGes.TicketGes.Service.PrioriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priorite")
public class PrioriteController {

    @Autowired
    private PrioriteService prioriteService;

    @PostMapping
    public PrioriteEntity addPriorite(@RequestBody PrioriteEntity priorite){
        return this.prioriteService.createPriorite(priorite);
    }
}
