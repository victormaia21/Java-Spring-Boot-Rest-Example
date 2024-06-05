package com.victor_education.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.victor_education.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
