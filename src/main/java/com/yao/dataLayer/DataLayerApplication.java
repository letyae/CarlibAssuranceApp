package com.yao.dataLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yao.dataLayer.model.Product;
import com.yao.dataLayer.model.Comment;
import com.yao.dataLayer.model.Category;

import com.yao.dataLayer.service.CategoryService;
import com.yao.dataLayer.service.CommentService;
import com.yao.dataLayer.service.ProductService;

import jakarta.transaction.Transactional;

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
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("**************Product********************");

		Iterable<Product> products =  productService.getProducts();		
		products.forEach (product -> System.out.println(product.getName()));
		
        Optional<Product> OptProduct =  productService.getProductById(1);		
		Product product1 = OptProduct.get();
		 System.out.println(product1.getName());
		 product1.getComments().forEach (comment -> System.out.println(comment.getContent()));
		
		
		System.out.println("**************Comment********************");

		Iterable<Comment> comments =  commentService.getComment();
		comments.forEach (comment -> System.out.println(comment.getContent()));
		
		 Optional<Comment> OptComment =  commentService.getCommentById(1);		
		 Comment comment1 = OptComment.get();
		 System.out.println(comment1.getContent());
		
		System.out.println("**************Category********************");
		
		Iterable<Category> categories =  categoryService.getCategory();
		categories.forEach (category -> System.out.println(category.getName()));
		
		 Optional<Category> OptCategory =  categoryService.getCategoryById(1);		
		 Category Category1 = OptCategory.get();
		 System.out.println(Category1.getName()); 	

    }  
		
}
