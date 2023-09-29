package com.masaischool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(nullable = false)
	private String productName;
	
	@NotBlank
	private Double price;
	
	@Column(nullable = false)
	private String color;
	
	private String dimension;
	
	@NotBlank
	private String specification;
	
	@NotBlank
	private String manufacturer;
	
	@NotBlank
	private Integer quantity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Product(String productName, @NotBlank Double price, String color, String dimension,
			@NotBlank String specification, @NotBlank String manufacturer, @NotBlank Integer quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}
	
	
}





