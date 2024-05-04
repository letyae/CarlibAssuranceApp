package com.yao.dataLayer.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.yao.dataLayer.model.Comment;
@Entity
@Table(name="produit")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="produit_id")
	private int productId;
	
	@Column(name ="nom")
	private String name;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="cout")
	private int cost;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch= FetchType.EAGER
			)	
	@JoinColumn(name="produit_id")
	  List<Comment> comments= new ArrayList<>();
	
	@ManyToMany(
			mappedBy="products"
			)
	 List<Category> categories = new ArrayList<>();

	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
		
}