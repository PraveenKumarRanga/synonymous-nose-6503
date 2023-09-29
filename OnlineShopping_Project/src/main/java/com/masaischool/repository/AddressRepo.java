package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	
	public Optional<Address> findByCustomerId(Integer customerId);
	
	public Optional<Address> deleteByCustomerId(Integer customerId);
	
}
