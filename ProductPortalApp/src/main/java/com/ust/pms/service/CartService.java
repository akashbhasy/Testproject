package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Model.Cart;
import com.ust.repository.CartRepository;


@Service
public class CartService {

	@Autowired
	CartRepository cartrepository;

	public List<Cart> getCarts() {
		return (List<Cart>) cartrepository.findAll();

	}

	public Cart getCart(Integer CartId) {
		Optional<Cart> Cart = cartrepository.findById(CartId);
		return Cart.get();
	}

	public void saveCart(Cart Cart) {

		cartrepository.save(Cart);
	}

	public void deleteCart(Integer Cartid) {

		cartrepository.deleteById(Cartid);
	}

	public void updateCart(Cart Cart) {

		cartrepository.save(Cart);
	}

	
	public boolean isCartExist(int CartId) {
		return cartrepository.existsById(CartId);
	}
	
	public int sizeOfCart() {
		return (int) cartrepository.count();
	}
}
