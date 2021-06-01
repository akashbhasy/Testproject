package com.ust.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.Model.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
