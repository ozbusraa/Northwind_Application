package com.example.northwind.business.concreates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concreates.CategoryRepository;
import com.example.northwind.dataaccess.concreates.ProductRepository;
import com.example.northwind.entities.concreates.Category;
import com.example.northwind.entities.concreates.Product;

@Service
public class CategoryManager implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		//business logic
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Integer categoryId) throws Exception {	
		return categoryRepository.findById(categoryId).orElseThrow(()->new Exception("No category with id: "+categoryId));
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Category categoryToDelete) {
		categoryRepository.delete(categoryToDelete);
	}

}
