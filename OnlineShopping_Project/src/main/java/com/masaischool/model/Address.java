package com.masaischool.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	@Column(nullable = false)
	private String streedNum;
	
	private String buildingNum;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String pincode;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "address",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> order;

	public Address(String streedNum, String buildingNum, String city, String state, String country, String pincode,
			List<Orders> order) {
		super();
		this.streedNum = streedNum;
		this.buildingNum = buildingNum;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.order = order;
	}
	
	
	
}




