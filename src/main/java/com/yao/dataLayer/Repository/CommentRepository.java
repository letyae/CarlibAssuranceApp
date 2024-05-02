package com.yao.dataLayer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yao.dataLayer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}


