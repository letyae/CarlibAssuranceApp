package com.yao.dataLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Product;
import service.CategoryService;
import service.CommentService;
import service.ProductService;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner{
	@Autowired
	private ProductService productService;
	
	@Autowired
    private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;
    
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Iterable<Product> products =  productService.getProducts();
		products.forEach(product ->System.out.println(product.getName()));	
    }
		
}
