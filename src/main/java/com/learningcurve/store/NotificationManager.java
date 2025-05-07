package com.learningcurve.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

//    call interface here and then refer which service needs to be called
//    i.e. email or sms
    private NotificationService notificationService;

//    Constructor
    public NotificationManager(@Qualifier("Email") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendMessage(String message){
        notificationService.send(message);
    }

//    getter setter


    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
