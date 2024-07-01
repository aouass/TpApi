package com.TicketGes.TicketGes.Controller;

import com.TicketGes.TicketGes.Entity.CategorieEntity;
import com.TicketGes.TicketGes.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PostMapping
    public CategorieEntity addCategorie(@RequestBody CategorieEntity categorie){
        return this.categorieService.createCategorie(categorie);
    }
}
