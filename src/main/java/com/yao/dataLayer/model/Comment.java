package com.yao.dataLayer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="commentaire")
public class Comment{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commentaire_id")
	private int contentId;
	
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
