package com.example.northwind.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concreates.CategoryRepository;
import com.example.northwind.dataaccess.concreates.ProductRepository;
import com.example.northwind.entities.concreates.Category;
import com.example.northwind.entities.concreates.Product;

@Service
public class ProductManager implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Product> getAll() {
		//business logic
		return productRepository.findAll();
	}

	@Override
	public Product findById(Integer productId) throws Exception {	
		return productRepository.findById(productId).orElseThrow(()->new Exception("No product with id: "+productId));
	}

	@Override
	public Product save(Product product) throws Exception {
		String productName= product.getProductName();
		int categoryId=product.getCategoryId();
		List<Product> productsWithSameCategoryId = productRepository.findByCategoryId(categoryId);
		if (productName.length()< 2) {
			throw new Exception("Product name is too short");
			//return productRepository.findById(-1).orElseThrow(()->new Exception("Product name is too short"));
		}
		else if (productsWithSameCategoryId.size()>=10) {
			throw new Exception("You can not add new product for this category");
		}
		else {
			return productRepository.save(product);
		}
		
	}

	@Override
	public void delete(Product productToDelete) {
		productRepository.delete(productToDelete);
	}


}
