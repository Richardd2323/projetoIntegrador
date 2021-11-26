package com.reciclamais.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reciclamais.demo.model.Product;
import com.reciclamais.demo.servico.ProductServiceI;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	ProductServiceI productService;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		
		return new ModelAndView("escolhaMaterial");
	}
	
	@GetMapping("/table")
	public ModelAndView table() {
		ModelAndView mv = new ModelAndView("tableProduct");
		mv.addObject("products", productService.findAll());
		return mv;
	}
	
	@GetMapping("/infoProduct")
	public ModelAndView infoProduct() {
		return new ModelAndView("infoProduct");
	}
	
	@GetMapping("/registerProduct")
	public ModelAndView productForm(Product product) {
		ModelAndView mv = new ModelAndView("registerProduct");
		mv.addObject("product", product);
		return mv;
	}
	
	@GetMapping("/consultProduct")
	public ModelAndView consultproduct(Product product) {
		ModelAndView mv = new ModelAndView("consultProduct");
		
		mv.addObject("products", productService.findAll());
		
		return mv;
	}
	
	@GetMapping("/consultProduct/metal")
	public ModelAndView consultproductMetal(Product product) {
		ModelAndView mv = new ModelAndView("consultProduct");
		mv.addObject("products", productService.findByMaterial("Metal"));
		return mv;
	}
	
	@GetMapping("/consultProduct/vidro")
	public ModelAndView consultproductVidro(Product product) {
		ModelAndView mv = new ModelAndView("consultProduct");
		mv.addObject("products", productService.findByMaterial("Vidro"));
		return mv;
	}
	
	@GetMapping("/consultProduct/papel")
	public ModelAndView consultproductPapel(Product product) {
		ModelAndView mv = new ModelAndView("consultProduct");
		mv.addObject("products", productService.findByMaterial("Papel"));
		return mv;
	}
	
	@GetMapping("/consultProduct/plastico")
	public ModelAndView consultproductPlastico(Product product) {
		ModelAndView mv = new ModelAndView("consultProduct");
		mv.addObject("products", productService.findByMaterial("Plastico"));
		return mv;
	}
	
	@GetMapping("/consultProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("tableProduct");
		
		productService.deleteById(id);
		modelAndView.addObject("products", productService.findAll());
		return modelAndView;
		
	}
	
	@PostMapping("/consultProduct")
	public ModelAndView save( @Valid Product product, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("tableProduct");
		if (result.hasErrors()) {
			modelAndView.setViewName("registerProduct");
		} else {
			modelAndView = productService.saveOrUpdate(product);
		}
		return modelAndView;
	}
	
	@GetMapping("/infoProduct/{id}")
	public ModelAndView infoProduct(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("infoProduct");
		modelAndView.addObject("product", productService.findById(id));
		return modelAndView;
	}
}
