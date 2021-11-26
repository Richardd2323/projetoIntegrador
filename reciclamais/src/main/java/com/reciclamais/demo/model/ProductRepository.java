package com.reciclamais.demo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
	List<Product> findByMaterial(String material);
	
}
