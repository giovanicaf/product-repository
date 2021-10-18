package com.github.giovanicaf.productrepository;

import com.github.giovanicaf.productrepository.entities.Category;
import com.github.giovanicaf.productrepository.entities.Product;
import com.github.giovanicaf.productrepository.repositories.CategoryRepository;
import com.github.giovanicaf.productrepository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProductRepositoryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductRepositoryApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;


	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L, "Eletronics");
		Category cat2 = new Category(2L, "Books");

		Product p1 = new Product(1L, "TV", 2200.00, cat1);
		Product p2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(3L, "PS5", 2800.00, cat1);
		Product p4 = new Product(4L, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));


		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);

	}
}
