package com.learningcurve.store.Services;

import com.learningcurve.store.entities.Category;
import com.learningcurve.store.entities.Product;
import com.learningcurve.store.entities.User;
import com.learningcurve.store.repositories.AddressRepository;
import com.learningcurve.store.repositories.CategoryRepository;
import com.learningcurve.store.repositories.ProductRepository;
import com.learningcurve.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@Component
public class UserServices {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityState(){
        var user = User.builder()
                .name("Rahul")
                .email("rahul@gmail.com")
                .password("<PASSWORD>")
                .build();

        if(entityManager.contains(user))
            System.out.println("persistent");
        else
            System.out.println("transient");

//        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("persistent");
        else
            System.out.println("transient");
    }


    @Transactional
    public void showRelatedEntity(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.printf(address.getUser().getName());
    }

    @Transactional
    public void manageProducts(){
        var product1 = Product.builder()
                .name("Product 1")
                .description("Description 1")
                .price(BigDecimal.valueOf(10))
                .build();

        productRepository.save(product1);


//        var user = userRepository.findById(1L).orElseThrow();
//        var products = productRepository.findAll();
//        products.forEach(product -> user.addProducts(product));
////        user::addProducts(product); ---- alternative syntax
//        userRepository.save(user);
    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

    //
    @Transactional
    public void fetchProducts(){
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example =  Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

}
