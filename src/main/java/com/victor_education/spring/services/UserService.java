package com.victor_education.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.victor_education.spring.dto.UserDto;
import com.victor_education.spring.entities.User;
import com.victor_education.spring.repositories.UserRepository;
import com.victor_education.spring.responses.Message;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Page<User> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User createdUser(UserDto user) {
		User newUser = new User(null, user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
		return repository.save(newUser);
	}
	
	public User updatedUserById(Long id, UserDto user) {
		Optional<User> data = repository.findById(id);
		
		data.get().setEmail(user.getEmail());
		data.get().setName(user.getEmail());
		data.get().setPassword(user.getPassword());
		data.get().setPhone(user.getPhone());
		
		return repository.save(data.get());
	}
	
	public Message deleteUserById(Long id) {
		repository.deleteById(id);
		
		Message message = new Message("Usuario deletado com sucesso");
		return message;
	}
}
