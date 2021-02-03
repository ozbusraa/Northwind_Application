package com.example.northwind.dataaccess.concreates;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.northwind.entities.concreates.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    //@Query("select p from Product p where p.categoryId = ?1")
    List<Product> findByCategoryId(int categoryId);
}
