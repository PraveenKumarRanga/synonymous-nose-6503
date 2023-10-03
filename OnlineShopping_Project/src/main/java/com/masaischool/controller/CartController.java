package com.masaischool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Cart;
import com.masaischool.model.Product;
import com.masaischool.service.CartServiceImpl;
import com.masaischool.service.ProductServiceImpl;

@RestController
public class CartController {

	private CartServiceImpl cartService;
	
	private ProductServiceImpl prodService;

	public CartController(CartServiceImpl cartService, ProductServiceImpl prodService) {
		super();
		this.cartService = cartService;
		this.prodService = prodService;
	}




	@PostMapping("/add_to_cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart, @RequestParam Integer product,@RequestParam Integer Quantity){
		
		
		return new ResponseEntity<Cart>(cartService.addProductToCart(cart, product, Quantity),HttpStatus.CREATED);
	}
	
	@PutMapping("/update_quantity")
	public ResponseEntity<Cart> updateProductQuantity(@RequestBody Cart cart, @RequestParam Integer product,@RequestParam Integer Quantity){
		
		
		return new ResponseEntity<Cart>(cartService.updateProductQuantity(cart, product, Quantity),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove_product")
	public ResponseEntity<Cart> removeProduct(@RequestBody Cart cart, @RequestParam Integer productId){
		
		return new ResponseEntity<Cart>(cartService.removeProductFromCart(cart, productId),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/remove_all_products")
	public ResponseEntity<Cart> removeAllProduct(@RequestBody Cart cart){
		
		return new ResponseEntity<Cart>(cartService.removeAllProducts(cart),HttpStatus.OK);
		
	}
	
	@GetMapping("/get_all_products")
	public ResponseEntity<List<Product>> getAllProduct(@RequestBody Cart cart){
		
		return new ResponseEntity<List<Product>>(cartService.viewAllProductsInCart(cart),HttpStatus.OK);
		
	}
	
}








