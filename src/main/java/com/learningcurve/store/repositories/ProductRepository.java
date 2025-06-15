package com.learningcurve.store.repositories;

import com.learningcurve.store.dtos.ProductSummary;
import com.learningcurve.store.dtos.ProductSummaryDTO;
import com.learningcurve.store.entities.Category;
import com.learningcurve.store.entities.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //Null
    List<Product> findByDescriptionIsNull();
    List<Product> findByDescriptionIsNotNull();

    // Multiple conditionsMore actions
    List<Product> findByDescriptionNullAndNameNull();

    // Sort (OrderBy)
    List<Product> findByNameOrderByPrice(String name);

    // Limit (Top/First)
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find products whose prices are in a given range and sort by nameMore actions
    // SQL or JPQL
//    @Query("Select p from Product p join p.category where p.price between :min and :max order by p.name")
    @Procedure("findProductsByPrice")
    List<Product> findProduct(BigDecimal min,BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min")BigDecimal min, @Param("max") BigDecimal max);


    //mind the args
    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice,Byte categoryId);

    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummary> findByCategory(@Param("category") Category category);
}