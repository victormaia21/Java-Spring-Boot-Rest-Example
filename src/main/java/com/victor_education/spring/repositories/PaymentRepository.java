package com.victor_education.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor_education.spring.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
