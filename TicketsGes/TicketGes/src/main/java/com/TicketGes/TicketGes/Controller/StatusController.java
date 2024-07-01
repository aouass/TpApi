package com.TicketGes.TicketGes.Controller;

import com.TicketGes.TicketGes.Entity.StatusEntity;
import com.TicketGes.TicketGes.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public StatusEntity addStatus(@RequestBody StatusEntity status){
        return this.statusService.createStatus(status);
    }
}
