package com.yao.dataLayer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="commentaire")
public class Comment{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commentaire_id")
	private int contentId;
	
	@ManyToOne(
			cascade = { 
				    	CascadeType.PERSIST,
					    CascadeType.MERGE
			        }
			)
	@JoinColumn(name="produit_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="contenu")
	private String content; 
	
	
	
}
