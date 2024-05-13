package com.yao.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yao.dataLayer.Repository.CategoryRepository;
import com.yao.dataLayer.model.Category;
import com.yao.dataLayer.model.Product;

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
        
    public Category saveCategory(Category category){
	    return categoryRepository.save(category);
	}   
    
    public void deleteCategoryById(int id){
	     categoryRepository.deleteById(id);
	}
                
    public Iterable<Category> findByCategoriesName(String name){
        return categoryRepository.findByCategoriesName(name);
   }
    
    public Iterable<Category>  findByCategoriesProductName(String name){
        return categoryRepository.findByCategoriesProductName(name);
   }
       
}
