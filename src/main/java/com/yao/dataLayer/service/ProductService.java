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
    

}
 
