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
		System.out.println("**********Product no 1:");

        Optional<Product> OptProduct =  productService.getProductById(1);		
		Product product1 = OptProduct.get();
		
		System.out.println("**************Product no1:");
		
		System.out.println("Produit no1: "+product1.getName());
		product1.getComments().forEach (comment -> System.out.println("Comments du produit no1: "+comment.getContent()));
		
		System.out.println("************** Create Product :");
		Product product2 = new Product();
		product2.setName("AssuranceHabitation");
		product2.setDescription("Assurance couvrant tous les accessoires de l'habitat");
		product2.setCost(300); 
		
		product2 =productService.saveProduct(product2); 
		System.out.println("product2 id: "+ product2.getProductId() );
		
		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));
						
		
		System.out.println("**************Comment********************");

		Iterable<Comment> comments =  commentService.getComment();
		comments.forEach (comment -> System.out.println(comment.getContent()));
		
		System.out.println("**************Comment no1:");

		Optional<Comment> OptComment =  commentService.getCommentById(1);		
		Comment comment1 = OptComment.get();
		
		System.out.println("Comment no1: "+comment1.getContent());
		
		System.out.println("Produit du comment no1: "+comment1.getProduct().getName());
		System.out.println("**************creation de Comment:");
		
		Comment comment2=  new Comment();
		comment2.setContent(" Excellente assurance sans risques en 2024 ! ");
		product2.addComment(comment2); 
		//productService.saveProduct(product2);
		
		System.out.println("**************Category********************");
		
		Iterable<Category> categories =  categoryService.getCategory();
		categories.forEach (category -> System.out.println(category.getName()));
		
		Optional<Category> OptCategory =  categoryService.getCategoryById(1);		
		Category Category1 = OptCategory.get();
		System.out.println(Category1.getName());
		
		Category category2 = new Category();
		//category2.setCategoryId(4);
		//category2.setName("JeunesEnseignants");
		category2.setName("Promotion");
		category2 =categoryService.saveCategory(category2); 
		System.out.println("category2 id: "+category2.getCategoryId());
		
		categoryService.getCategory().forEach(
				category -> System.out.println(category.getName()));
		
		//category2.setProducts(null);
		
		// Ds ce cas pas besoin de save
		Product productAssuranceAuTiers = productService.getProductById(1).get();	
		Comment newComment = new Comment();
		newComment.setContent("Assurance peu intéressante.");
		productAssuranceAuTiers.addComment(newComment); 
				
		//On peut enregistrer simultanement 2 objets en relation
		Category category3 = new Category();	
		category3.setName("-25");
		
		Product product3 = new Product();
		product3.setName("AssuranceAuTiers-25ans");
		product3.setDescription("Assurance au tiers réservée aux conducteurs de -25 ans.");
		product3.setCost(3000);
		
		category3.addProduct(product3);
		categoryService.saveCategory(category3);
		
		// UPDATE 
		Product productAssurance = productService.getProductById(2).get();	
		System.out.println("Cost: "+productAssurance.getCost());
		
		productAssurance.setCost(950);
	    productService.saveProduct(productAssurance);
	     
		Product productAssuranceUpdate = productService.getProductById(2).get();	
		System.out.println("Cost: " + productAssuranceUpdate.getCost());
		
		
	   //suppression d'objet product qui entraine la suppression des commentaires
		productService.deleteProductById(24);
		productService.deleteProductById(25);
		productService.deleteProductById(28);
		productService.deleteProductById(29);
		productService.deleteProductById(30);
		
		//suppression d'objet comment qui n'entraine pas la suppression des products
		commentService.deleteCommentById(25);
		commentService.deleteCommentById(27);
		commentService.deleteCommentById(29); 

		//suppression d'objet categorie
		//categoryService.deleteCategoryById(52);
		
		productService.deleteProductById(47);

		// Recherche 
		
		Iterable<Product> productsFind = productService.findByName("AssuranceHabitation");
					
			System.out.println("*********** Products Find: *********** ");
			
			productsFind.forEach (produit -> System.out.println("Name du produit find: "+produit.getName()));
			
			
			
			Iterable<Product> productsCategoriesFind = productService.findByCategoriesName("Standard");
			
			System.out.println("*********** Product find by their Categories Find: ***********"); 
			
			productsCategoriesFind.forEach (produit -> System.out.println("produit mame find: "+produit.getName()));
			
			
			
			
			System.out.println("*********** Products Find: *********** ");
			
			productsFind.forEach (produit -> System.out.println("Name du produit find: "+produit.getName()));
			
			
				
    }  		
}