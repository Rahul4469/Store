package com.learningcurve.store;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("Stripe")
//@Primary
public class StripePaymentService implements PaymentService {
//    Injecting values from Configuration file to our code
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe");
        System.out.println("Api url : " +apiUrl);
        System.out.println("Enabled:" +enabled);
        System.out.println("Currencies: " +supportedCurrencies);
        System.out.println("Amount : " + amount);

    }
}
