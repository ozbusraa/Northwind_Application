package com.example.northwind.business.abstracts;
import java.util.List;

import com.example.northwind.entities.concreates.Product;

public interface IProductService {

	List<Product> getAll();

	Product save(Product product) throws Exception;

	Product findById(Integer productId) throws Exception;

	void delete(Product productToDelete);

}
