package com.victor_education.spring.dto;

import com.victor_education.spring.entities.Payment;
import com.victor_education.spring.entities.User;
import com.victor_education.spring.enums.OrderStatus;

public class OrderDto {

	private OrderStatus orderStatus;
	private Payment payment;
	private User user;
	
	public OrderDto(OrderStatus orderStatus, Payment payment, User user) {
		super();
		this.orderStatus = orderStatus;
		this.payment = payment;
		this.user = user;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
