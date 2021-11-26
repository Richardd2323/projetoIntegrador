package com.reciclamais.demo.servico;

import org.springframework.web.servlet.ModelAndView;

import com.reciclamais.demo.model.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	
	
	public Product findById(Long id);
	
	public void deleteById(Long id);
	
	public ModelAndView saveOrUpdate(Product product);
}
