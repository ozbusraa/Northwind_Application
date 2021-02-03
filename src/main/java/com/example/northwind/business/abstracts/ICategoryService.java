package com.example.northwind.business.abstracts;
import java.util.List;

import com.example.northwind.entities.concreates.Category;
import com.example.northwind.entities.concreates.Product;

public interface ICategoryService {

	List<Category> getAll();

	Category findById(Integer categoryId) throws Exception;

	Category save(Category category);

	void delete(Category categoryToDelete);

}
