package com.victor_education.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.victor_education.spring.entities.Category;
import com.victor_education.spring.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Page<Category> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
