package com.victor_education.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor_education.spring.entities.OrderItem;
import com.victor_education.spring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
