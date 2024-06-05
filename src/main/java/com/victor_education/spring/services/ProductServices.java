package com.victor_education.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.victor_education.spring.entities.Product;
import com.victor_education.spring.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repository;

	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
