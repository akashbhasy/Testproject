package com.ust.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.Model.Cart;


public interface CartRepository extends CrudRepository<Cart, Integer> {

	
}
