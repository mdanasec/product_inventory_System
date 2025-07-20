package org.springboot.productinventorysystem.service;

import java.util.List;
import java.util.Optional;

import org.springboot.productinventorysystem.dao.ProductDao;
import org.springboot.productinventorysystem.entity.Product;
import org.springboot.productinventorysystem.entity.ResponseStructure;
import org.springboot.productinventorysystem.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
//	API Create Product
	public ResponseEntity<ResponseStructure<Product>> createProduct(Product product ){
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setData(productDao.createProduct(product));
		structure.setMessage("Product Save Sucessfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	}
	
//	API Get All Product
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
		
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		List<Product> recProduct = productDao.getAllProduct();
		
		if(recProduct.size()>0) {
			structure.setMessage("Product Found ");
			structure.setData(recProduct);
			structure.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		
		throw new ProductNotFoundException("Product Not Found ");
		
	}
	
//	API Get By Id
	public ResponseEntity<ResponseStructure<Optional<Product>>> getProductById(long id){
		
		ResponseStructure<Optional<Product>> structure = new ResponseStructure<>();
		
		Optional<Product> recProduct = productDao.getProductById(id);
		
		if(recProduct.isPresent()) {
			
			structure.setMessage("Product Found");
			structure.setData(recProduct);
			structure.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Optional<Product>>> (structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Id" + id + " product not found");
		
	}
	
//	API Update Product By Id
	public ResponseEntity<ResponseStructure<Product>> updateProductById (Product product , long id) {
		
		ResponseStructure<Product> structure= new ResponseStructure<>();
		
		Optional<Product> recProduct = productDao.getProductById(id);
		
		if(recProduct.isPresent()) {
			Product existProduct = recProduct.get();
			existProduct.setName(product.getName());
			existProduct.setCategory(product.getCategory());
			existProduct.setQuantity(product.getQuantity());
			existProduct.setPrice(product.getPrice());
			existProduct.setStatus(product.getStatus());
			
			Product updateProduct = productDao.createProduct(existProduct);
			
			structure.setMessage("Product Updated Sucessfully");
			structure.setData(updateProduct);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>> (structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product not found By Id : " + id);
	}
	
//	API Delete By Id
	public ResponseEntity<ResponseStructure<String>> deleteById (long id) {
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productDao.getProductById(id);
		
		if(recProduct.isPresent()) {
			productDao.deleteById(id);
			structure.setMessage(" Product delete by id ");
			structure.setData("Delete Sucessfully");
			structure.setStatuscode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<String>> (structure, HttpStatus.NO_CONTENT);
		}
		throw new ProductNotFoundException("Product Not Found In the id of : " + id);
		
	}
	
}





















