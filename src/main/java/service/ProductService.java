package service;
<<<<<<< HEAD

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
=======
import org.springframework.stereotype.Service;

@Service
public class ProductService {

>>>>>>> cbf46cbb80b4bf03d8d04d7f18d93ea0f1a7c836
}
