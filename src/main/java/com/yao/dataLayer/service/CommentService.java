package com.yao.dataLayer.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yao.dataLayer.Repository.CommentRepository;
import com.yao.dataLayer.model.Comment;

@Service
public class CommentService {
	
	
	@Autowired
    private CommentRepository commentRepository;
 
 public Iterable<Comment> getComment(){
    return commentRepository.findAll();
  }

 public Optional<Comment> getCommentById(int id){
	    return commentRepository.findById(id);
	  }

}
