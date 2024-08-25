package com.Java1.Java_SB1.repo;

import com.Java1.Java_SB1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {




    @Query("SELECT p from Product p WHERE "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword,'%'))")
    List<Product> searchProducts(String keyword);
//    List<Product> searchProducts(String keyword);
}
