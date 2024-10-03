package com.guilherme.java.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilherme.java.entities.Category;
import com.guilherme.java.entities.Order;
import com.guilherme.java.entities.Product;
import com.guilherme.java.entities.User;
import com.guilherme.java.entities.enums.OrderStatus;
import com.guilherme.java.repositories.CategoryRepository;
import com.guilherme.java.repositories.OrderRepository;
import com.guilherme.java.repositories.ProductRepository;
import com.guilherme.java.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Buscando o anel perdido", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Lorem Ipsum", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Sem Mac por enquanto", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Saudade de Jogar FIFA", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cree en grande", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99999", "12345");
		User u2 = new User(null, "Xablau Silva", "xs@gmail.com", "989999", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
