package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masaischool.model.Cart;
import com.masaischool.model.Product;
import com.masaischool.repository.CartRepo;

@Service
public class CartServiceImpl implements CartService{

	private CartRepo cartRepo;
	
	private ProductServiceImpl prodService;
	
	public CartServiceImpl(CartRepo cartRepo, ProductServiceImpl prodService) {
		super();
		this.cartRepo = cartRepo;
		this.prodService = prodService;
	}

	@Override
	public Cart addProductToCart(Cart cart, Integer productId, Integer quantity) {
		
		Product product = prodService.getProductById(productId);
		
		if(product != null) {
			Optional<Product> exiProduct = cart.getProduct().stream()
                    .filter(p -> p.getProductId().equals(product.getProductId()))
                    .findFirst();
			if(exiProduct.isPresent()) {
				exiProduct.get().setQuantity(exiProduct.get().getQuantity()+ quantity);
			}
			else {
				product.setCart(cart);
				product.setQuantity(quantity);
				cart.getProduct().add(product);
			}
		}
		 
		return cart;
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Integer productId) {
		
		cart.getProduct().removeIf(p -> p.getProductId().equals(productId));
		return cart;
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Integer productId, Integer quantity) {
		
		Optional<Product> exiProd = cart.getProduct().stream()
				.filter(p -> p.getProductId().equals(productId))
				.findFirst();
		
		if(exiProd.isPresent()) {
			exiProd.get().setQuantity(quantity);
		}
		
		return cart;
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		cart.getProduct().clear();
		return cart;
	}

	@Override
	public List<Product> viewAllProductsInCart(Cart cart) {
		
		return cart.getProduct();
	}

}
