package com.TicketGes.TicketGes.Service;


import com.TicketGes.TicketGes.Entity.NotificationEntity;
import com.TicketGes.TicketGes.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void  envoyerNotificationcreate(NotificationEntity notification){
        notification.setMessage("Nouveau ticket créé:" + notification.getTicket().getTitre() + "(ID:" + notification.getTicket().getId_ticket() + ")");
        notificationRepository.save(notification);
    }

    public void envoyerNotificationupdate(NotificationEntity notification){
        notification.setMessage("Ticket mis à jour: " + notification.getTicket().getTitre() + "(ID:" + notification.getTicket().getId_ticket() + ")");
        notificationRepository.save(notification);
    }

    public void envoyerNotificationdelete(NotificationEntity notification){
        notification.setMessage("Ticket supprimé: " + notification.getTicket().getTitre() + "(ID:" + notification.getTicket().getId_ticket() + ")");
        notificationRepository.save(notification);
    }
}
