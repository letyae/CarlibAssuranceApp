package com.yao.dataLayer.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yao.dataLayer.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public Iterable<Product> findByName(String Name);
	public Iterable<Product> findByCategoriesName(String Name);
	
	//requette JPQL
	@Query("FROM PRODUCT WHERE name=?1")
	public Iterable<Product> findByNameJPQL(String Name);
	
	//requette Native
	@Query(value="SELECT * FROM PRODUCT WHERE cout=:cout", nativeQuery=true);
	public Iterable<Product> findByName(@Param('cout') Integer cost);
}
