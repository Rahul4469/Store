package com.learningcurve.store;

import com.learningcurve.store.Services.UserServices;
import com.learningcurve.store.entities.User;
import com.learningcurve.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
                ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
                var services = context.getBean(UserServices.class);

                services.fetchProducts();





    }

}
