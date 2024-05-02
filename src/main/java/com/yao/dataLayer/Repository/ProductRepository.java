package com.yao.dataLayer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yao.dataLayer.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
