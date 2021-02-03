package com.example.northwind.dataaccess.concreates;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concreates.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
