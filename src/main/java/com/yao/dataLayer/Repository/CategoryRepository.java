package com.yao.dataLayer.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yao.dataLayer.model.Category;
import com.yao.dataLayer.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	public Iterable<Category> findByCategoriesName(String name);
	public Iterable<Category> findByCategoriesProductName(String name);
	 public Iterable<Category> findByAllCategories();
		
	
}
