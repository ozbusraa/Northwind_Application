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

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concreates.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {

	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getById(@PathVariable(value="id")Integer productId) throws Exception{
		return productService.findById(productId);
	}
	
	@PostMapping("/products")
	public Product add(@RequestBody Product product) throws Exception {
		System.out.println(product.getProductName());
		return productService.save(product);
	}
	
	@PutMapping("/products/{id}")
	public Product update(@PathVariable(value="id")Integer productId,@RequestBody Product product)throws Exception{
		Product productToUpdate = productService.findById(productId);
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setQuantityPerUnit(product.getQuantityPerUnit());
		productToUpdate.setSupplierId(product.getSupplierId());
		Product updatedProduct=productService.save(productToUpdate);
		return  updatedProduct;	
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable(value="id") Integer productId) throws Exception{

		Product productToDelete = productService.findById(productId);
		productService.delete(productToDelete);
		System.out.println(productToDelete.getProductName()+" silindi.");
	}
}
