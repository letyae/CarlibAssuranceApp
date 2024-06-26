package com.yao.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yao.dataLayer.Repository.ProductRepository;
import com.yao.dataLayer.model.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
 
    public Iterable<Product> getProducts(){
       return productRepository.findAll();
  }
 
    public Optional<Product> getProductById(int id){
       return productRepository.findById(id);
	  }
    

    public Product saveProduct(Product product){
        return productRepository.save(product);
 	  }
    
    public void deleteProductById(int id){
         productRepository.deleteById(id);
 	  }
    
    public Iterable<Product> findByName(String name){
        return productRepository.findByName(name);
   }
            
    public Iterable<Product> findByCategoriesName(String name){
        return productRepository.findByCategoriesName(name);
   }
        
	public Iterable<Product> findByCostLessThan(Integer cost){
		 return productRepository.findByCostLessThan(cost);
	}

}
 
