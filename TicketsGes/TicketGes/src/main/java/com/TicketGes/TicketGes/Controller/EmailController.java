package com.TicketGes.TicketGes.Controller;


import com.TicketGes.TicketGes.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notifications")
public class EmailController {

   @Autowired
   private EmailService emailService;

   @PostMapping("/envoiemail")
   public ResponseEntity<String> sendEmail(@RequestBody String to , @RequestParam String subject , @RequestParam String text ) {
       emailService.sendEmail(to , subject, text);
        return ResponseEntity.ok().body("Email envoyé avec succès!");
   }
}
