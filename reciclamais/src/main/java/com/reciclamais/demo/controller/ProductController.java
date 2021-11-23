package com.reciclamais.demo.controller;

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
	
	@Autowired
	ProductServiceI productService;
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("escolhaMaterial");
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
	
	@PostMapping("/consultProduct")
	public ModelAndView save(Product product, BindingResult result) {
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
