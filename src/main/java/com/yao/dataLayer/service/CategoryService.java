package com.yao.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yao.dataLayer.Repository.CategoryRepository;
import com.yao.dataLayer.model.Category;

@Service
public class CategoryService {
	
	
    @Autowired
    private CategoryRepository categoryRepository;
 
    public Iterable<Category> getCategory(){
            return categoryRepository.findAll();
  }

    public Optional<Category> getCategoryById(int id){
	    return categoryRepository.findById(id);
	  }
}
