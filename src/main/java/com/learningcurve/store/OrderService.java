package com.learningcurve.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
//    Taking data from Interface(method) > PaymentClasses
    private PaymentService paymentService;


//    Constructors
    public OrderService( PaymentService paymentService) {
        System.out.println("OrderService Constructor intialized");
        this.paymentService = paymentService;
    }

//    ------------------
    public void placeOrder(){
        paymentService.processPayment(10);
    }
//    ----------------

//    Getter and Setters
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
