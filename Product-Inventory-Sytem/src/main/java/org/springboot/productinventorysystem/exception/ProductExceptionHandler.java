package org.springboot.productinventorysystem.exception;

import org.springboot.productinventorysystem.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


//@ControllerAdvice is a Spring annotation used to handle exceptions, bind data, 
//or apply common logic globally to all controllers in a centralized manner.

@ControllerAdvice
public class ProductExceptionHandler {
	
	public ResponseEntity<ResponseStructure<String>> handlePNFE(ProductNotFoundException exception){
		ResponseStructure<String> structure = new ResponseStructure<>();
		
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		structure.setData("Product Not Found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
