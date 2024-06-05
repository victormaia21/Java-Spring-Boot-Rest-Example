package com.victor_education.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor_education.spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
