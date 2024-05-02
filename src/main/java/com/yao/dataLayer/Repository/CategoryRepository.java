package com.yao.dataLayer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yao.dataLayer.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
