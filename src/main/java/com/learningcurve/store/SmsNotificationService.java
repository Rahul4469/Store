package com.learningcurve.store;

import org.springframework.stereotype.Service;

@Service("SMS")
public class SmsNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Sending SMS :" + message);
    }
}
