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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="categorie")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="categorie_id")
	private int categoryId;

	@Column(name ="nom")
	private String name;
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)

	@JoinTable(
			name="categorie_produit",
			joinColumns=@JoinColumn(name="categorie_id"),
			inverseJoinColumns=@JoinColumn(name="produit_id")
			) 

	List<Product> products = new ArrayList<>();

	//méthodes utilitaires

	public void addProduct(Product product) {
		products.add(product);
		product.getCategories().add(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.getCategories().remove(this);
	} 

	public int getCategoryId() {
		return categoryId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
} 