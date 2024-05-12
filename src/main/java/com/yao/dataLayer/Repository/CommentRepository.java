package com.yao.dataLayer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yao.dataLayer.model.Comment;
import com.yao.dataLayer.model.Product;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
 
	// commentaires contenant une expression
	public Iterable<Comment>  findByContentContaining(String expression);
	
}


