package com.victor_education.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor_education.spring.dto.UserDto;
import com.victor_education.spring.entities.User;
import com.victor_education.spring.responses.Message;
import com.victor_education.spring.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/users")
@Tag(name = "User", description = "Endpoint para gerenciar produtos")
public class UserResources {
	
	@Autowired
	private UserService service;

	@Operation(summary = "Procurar todos os usuarios")
	@GetMapping
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		Page<User> users = service.findAll(pageable);
		return ResponseEntity.ok().body(users);
	}
	
	@Operation(summary = "Procurar usuario por id")
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	@Operation(summary = "Criar um novo usuario")
	public ResponseEntity<User> createdUser(@RequestBody UserDto user) {
		User newUser = service.createdUser(user);
		return ResponseEntity.ok().body(newUser);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um usuario por id")
	public ResponseEntity<User> updatedUser(@PathVariable Long id, @RequestBody UserDto user) {
		User newUser = service.updatedUserById(id, user);
		return ResponseEntity.ok().body(newUser);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Endpoint para deletar um usuario por id")
	public ResponseEntity<Message> deleteUserById(@PathVariable Long id) {
		Message message = service.deleteUserById(id);
		return ResponseEntity.ok().body(message);
	}
}
