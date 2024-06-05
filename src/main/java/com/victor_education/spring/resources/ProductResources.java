package com.victor_education.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor_education.spring.entities.Product;
import com.victor_education.spring.services.ProductServices;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Products", description = "Endpoint para gerenciar produtos")
public class ProductResources {

	@Autowired
	ProductServices service;
	
	@GetMapping
	public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
}
