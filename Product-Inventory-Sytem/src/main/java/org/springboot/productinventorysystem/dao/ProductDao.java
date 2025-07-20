package org.springboot.productinventorysystem.dao;

import java.util.List;
import java.util.Optional;

import org.springboot.productinventorysystem.entity.Product;
import org.springboot.productinventorysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@Repository is a Spring annotation that marks a class as a Data Access Object (DAO),
//enabling exception translation and allowing it to interact with the database layer.
@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	
//	createProduct
	public Product createProduct(Product product ) {
		return productRepository.save(product);
	}
	
	
//	getAllProduct
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
//	getProductById
	public Optional<Product> getProductById(long id){
		return productRepository.findById(id);
	}
	
//	updateProduct
	public Product updateProductById(Product product , long id) {
		return productRepository.save(product);
	}
	
//	deleteById
	public boolean deleteById (long id) {
		Optional<Product> recProduct = getProductById(id);
		
		if(recProduct.isPresent()) {
			productRepository.delete(recProduct.get());
			return true;
		}
		return false;
	}

}
















