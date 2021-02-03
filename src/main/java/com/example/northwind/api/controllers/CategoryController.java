package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concreates.Category;
import com.example.northwind.entities.concreates.Product;

@RestController
@RequestMapping("/api/v2")
public class CategoryController {

	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	

	@GetMapping("/categories/{id}")
	public Category getById(@PathVariable(value="id")Integer categoryId) throws Exception{
		return categoryService.findById(categoryId);
	}
	
	@PostMapping("/categories")
	public Category add(@RequestBody Category category) {
		System.out.println(category.getCategoryName());
		return categoryService.save(category);
	}
	
	@PutMapping("/categories/{id}")
	public Category update(@PathVariable(value="id")Integer categoryId,@RequestBody Category category)throws Exception{
		Category categoryToUpdate = categoryService.findById(categoryId);
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setDescription(category.getDescription());
		return categoryService.save(categoryToUpdate);

	}
	
	@DeleteMapping("/categories/{id}")
	public void delete(@PathVariable(value="id") Integer categoryId) throws Exception{

		Category categoryToDelete = categoryService.findById(categoryId);
		categoryService.delete(categoryToDelete);
		System.out.println(categoryToDelete.getCategoryName()+" silindi.");
	}
}
