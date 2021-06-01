package com.ust.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.Model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	public List<Product> findByProductName(String ProductName);
	public List<Product> findByPriceGreaterThan(int price);
	public List<Product> findByPriceLessThan(int price);
	public List<Product> findByPriceBetween(int lowerprice,int higherprice);
}
