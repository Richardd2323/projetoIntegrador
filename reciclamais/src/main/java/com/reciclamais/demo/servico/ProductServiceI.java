package com.reciclamais.demo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.reciclamais.demo.model.Product;
import com.reciclamais.demo.model.ProductRepository;

@Service
public class ProductServiceI implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Iterable<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product findByMaterial(String material) {
		return productRepository.findByMaterial(material);
	}
	
	public ModelAndView saveOrUpdate(Product product) {
		ModelAndView modelAndView = new ModelAndView("tableProduct");
		try {
			productRepository.save(product);
			modelAndView.addObject("products", productRepository.findAll());
		}
		catch(Exception e) {
			modelAndView.setViewName("registerProduct");
			
		}
		return modelAndView;
	}
}
