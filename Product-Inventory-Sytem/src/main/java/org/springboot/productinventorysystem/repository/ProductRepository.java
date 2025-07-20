package org.springboot.productinventorysystem.repository;

import org.springboot.productinventorysystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>  {
	

}
