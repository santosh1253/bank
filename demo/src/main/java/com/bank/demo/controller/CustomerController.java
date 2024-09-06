package com.bank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entity.Customer;
import com.bank.demo.entity.Records;
import com.bank.demo.exceptions.MinBalanceException;
import com.bank.demo.exceptions.UserNotFoundException;
import com.bank.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer c) throws MinBalanceException, UserNotFoundException
	{
		return service.saveCustomer(c);
		
	}
	
	@GetMapping("/customer/{accno}")
	public Customer getCustomerByAcc(@PathVariable Long accno) throws UserNotFoundException
	{
		return service.findByAcc(accno);
	}
	
	@PutMapping("/customer/{accno}")
	public Customer updateCustomerByAcc(@RequestBody Customer customer,@PathVariable Long accno) throws UserNotFoundException
	{
		return service.updateCustomer(customer, accno);
	}
	
	@DeleteMapping("/customer/{accno}")
	public String deleteCustomerByAcc(@PathVariable Long accno) throws UserNotFoundException
	{
		Long id=service.deletCustomerById(accno);
		return "Customer with accno "+id+" deleted Successfully";
	}
	
	@GetMapping("/customer/records/{accno}")
	public Page<Records> getAllRecordsByAcc(@PathVariable Long accno,Pageable pageable)
	{
		return service.getAllRecordsById(accno,pageable);
	}
	
	@PutMapping("/customer/{accno}/{password}")
	public String updatePassword(@PathVariable Long accno,@PathVariable String password) throws UserNotFoundException
	{
		return service.updatePassword(password, accno);
	}
}
