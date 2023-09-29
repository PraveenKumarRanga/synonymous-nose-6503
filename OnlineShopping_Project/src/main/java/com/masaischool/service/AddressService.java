package com.masaischool.service;

import java.util.List;

import com.masaischool.model.Address;

public interface AddressService {

	public Address addAddress(Address address);
	
	public List<Address> getAllAddress();
	
	public Address getAddressByCustomerId(Integer customerId);
	
	public Address updateAddress(Address address);
	
	public Address deleteAddressByCustomerId(Integer customerId);
	
	
}
