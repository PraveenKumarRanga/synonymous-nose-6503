package com.masaischool.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(nullable = false)
	@Pattern(regexp = "[a-z]+", message = "name accepts alphabets only")
	private String firstName;
	
	@Pattern(regexp = "[a-z]+", message = "name accepts alphabets only")
	private String lastName;
	
	@Column(unique = true ,nullable = false)
	@Pattern(regexp = "[a-z0-9.]+@[a-z0-9]//.+[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE,
				message = "invalid email format")
	private String email;
	
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "[0-9]+", message = "mobile number accepts only digits")
	@Size(max = 10)
	private String mobileNum;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> address;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> order;

	public Customer(String firstName, String lastName, String email, String mobileNum,
			List<Address> address, User user, Cart cart, List<Orders> order) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNum = mobileNum;
		this.address = address;
		this.user = user;
		this.cart = cart;
		this.order = order;
	}
	
	
	
}
