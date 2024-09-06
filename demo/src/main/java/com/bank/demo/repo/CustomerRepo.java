package com.bank.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
	

}
