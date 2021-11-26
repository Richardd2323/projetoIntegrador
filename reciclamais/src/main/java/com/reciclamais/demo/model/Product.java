package com.reciclamais.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;



@Entity
@Table(name = "tb_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min = 1, max = 100, message = "O nome deve ser preenchido.")
	private String name;
	private boolean recycleable;
	@NotNull (message = "O material deve ser selecionado.")
	@Size
	private String material;
	@NotNull
	@Size(min = 1, max = 250, message = "Uma descrição deve ser feita.")
	private String description;
	
	public Product() {}

	public Product(Long id, String name, String material, String description) {
		super();
		this.id = id;
		this.name = name;
		
		this.material = material;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRecycleable() {
		return recycleable;
	}

	public void setRecycleable(boolean recycleable) {
		this.recycleable = recycleable;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
