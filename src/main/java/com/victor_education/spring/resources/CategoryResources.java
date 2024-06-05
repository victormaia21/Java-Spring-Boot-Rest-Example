package com.victor_education.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor_education.spring.entities.Category;
import com.victor_education.spring.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/categories")
@Tag(name = "Categories", description = "Endpoint para pegar gerenciar todas as cateogorias")
public class CategoryResources {
	
	@Autowired
	CategoryService service;

	@GetMapping
	@Operation(description = "Procurar todas as categorias paginada")
	public ResponseEntity<Page<Category>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
}
