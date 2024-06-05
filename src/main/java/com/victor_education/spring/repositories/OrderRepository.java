package com.victor_education.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor_education.spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
