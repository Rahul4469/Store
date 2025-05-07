package com.learningcurve.store;

import org.springframework.stereotype.Service;

//@Service("Paypal")
public class PaypalPaymentService implements PaymentService {
    //    Method from Interface(PaymentService)
    //    and add extra usability
    @Override
    public void processPayment(double amount){
        System.out.println("Paypal Payment");
        System.out.println("Amount: " + amount);
    }
}
