package com.learningcurve.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Email")
@Primary
public class EmailNotificationService implements NotificationService{

    @Override
    public void send(String message) {
        System.out.println("Sending Email :" + message);
    }
}
