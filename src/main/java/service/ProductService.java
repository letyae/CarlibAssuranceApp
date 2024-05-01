package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.ProductRepository;
import model.Product;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;
 
 public Iterable<Product> getProducts(){
    return productRepository.findAll();
  }

}
