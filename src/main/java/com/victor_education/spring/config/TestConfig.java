package com.victor_education.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victor_education.spring.entities.Category;
import com.victor_education.spring.entities.Order;
import com.victor_education.spring.entities.OrderItem;
import com.victor_education.spring.entities.Payment;
import com.victor_education.spring.entities.Product;
import com.victor_education.spring.entities.User;
import com.victor_education.spring.enums.OrderStatus;
import com.victor_education.spring.repositories.CategoryRepository;
import com.victor_education.spring.repositories.OrderItemRepository;
import com.victor_education.spring.repositories.OrderRepository;
import com.victor_education.spring.repositories.PaymentRepository;
import com.victor_education.spring.repositories.ProductRepository;
import com.victor_education.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        
        userRepository.saveAll(Arrays.asList(u1, u2));
        
        Order o1 = new Order(null, OrderStatus.PAID ,u1);
        Order o2 = new Order(null, OrderStatus.PAID ,u2);
        Order o3 = new Order(null, OrderStatus.WAITING_PAYMENT , u1);
        
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        
        Payment p1 = new Payment(null, Instant.now(), o1);
        Payment p2 = new Payment(null, Instant.now(), o2);
        
        o1.setPayment(p1);
        o2.setPayment(p2);
        
        paymentRepository.saveAll(Arrays.asList(p1,p2));
        
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        Product pr1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product pr2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product pr3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product pr4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product pr5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
        
        o1.getProducts().addAll(Arrays.asList(pr1, pr2));
        o2.getProducts().addAll(Arrays.asList(pr3, pr4));
        o3.getProducts().addAll(Arrays.asList(pr5));
        
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        
        pr1.getCategories().add(cat2);
        pr2.getCategories().add(cat3);
        pr3.getCategories().addAll(Arrays.asList(cat1, cat3));
        pr4.getCategories().addAll(Arrays.asList(cat1, cat3));
        pr5.getCategories().add(cat2);
        
        productRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
        
        cat1.getProducts().addAll(Arrays.asList(pr3,pr4));
        cat2.getProducts().addAll(Arrays.asList(pr5,pr1));
        cat3.getProducts().addAll(Arrays.asList(pr2,pr3,pr4));
        
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        OrderItem oi1 = new OrderItem(o1, pr1, 2, pr1.getPrice());
        OrderItem oi2 = new OrderItem(o1, pr3, 1, pr3.getPrice());
        OrderItem oi3 = new OrderItem(o2, pr3, 2, pr3.getPrice());
        OrderItem oi4 = new OrderItem(o3, pr5, 2, pr5.getPrice());
        
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
    }
}
