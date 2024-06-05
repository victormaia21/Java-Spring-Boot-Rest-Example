package com.victor_education.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.victor_education.spring.dto.OrderDto;
import com.victor_education.spring.entities.Order;
import com.victor_education.spring.repositories.OrderRepository;
import com.victor_education.spring.responses.Message;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	
	public Page<Order> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Optional<Order> findById(Long id) {
		Optional<Order> order = repository.findById(id);
		return order;
	}
	
	public Order createOrder(OrderDto order) {
		Order newOrder = new Order(null, order.getOrderStatus(), order.getUser(), null);
		return repository.save(newOrder);
	}
	
	public Order updateOrderById(OrderDto order, Long id) {
		Optional<Order> orderId = repository.findById(id);
		
		if(order.getOrderStatus() != null) {
			orderId.get().setOrderStatus(order.getOrderStatus());
		}
		
		if(order.getPayment() != null) {
			orderId.get().setPayment(order.getPayment());
		}
		
		return repository.save(orderId.get());
	}
	
	public Message deleteOrderById(Long id) {
		repository.deleteById(id);
		Message msg = new Message("Order delete with sucess");
		return msg;
	}
}
