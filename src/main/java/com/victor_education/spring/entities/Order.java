package com.victor_education.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.victor_education.spring.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private Instant moment;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@ManyToMany
	@JoinTable(
	    name = "order_product",
	    joinColumns = @JoinColumn(name = "order_id"),
	    inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	@JsonBackReference
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public Order() {}
	
	public Order(Long id, OrderStatus orderStatus, User user) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.user = user;
		if(this.moment == null) {
			this.moment = Instant.now();
		}
	}
	
	public Order(Long id, OrderStatus orderStatus, User user, Payment payment) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.user = user;
		this.payment = payment;
		if(this.moment == null) {
			this.moment = Instant.now();
		}
	}

	@PrePersist
    public void prePersist() {
        if (this.moment == null) {
            this.moment = Instant.now();
        }
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrderItem x : items) {
			total += x.getSubTotal(); 
		}
		
		return total;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
