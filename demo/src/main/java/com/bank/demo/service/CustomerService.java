package com.bank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.demo.PasswordGenerator;
import com.bank.demo.entity.Customer;
import com.bank.demo.entity.Records;
import com.bank.demo.exceptions.MinBalanceException;
import com.bank.demo.exceptions.UserNotFoundException;
import com.bank.demo.repo.CustomerRepo;
import com.bank.demo.repo.RecordRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo crepo;
	@Autowired
	private RecordRepo rrepo;

	public Customer saveCustomer(Customer c) throws MinBalanceException, UserNotFoundException {
		if (c.getAccno() == null && c.getBalance() < 2000) {
			throw new MinBalanceException("The minimum balance is 2000 to add an account");
		}
		c.setPassword(PasswordGenerator.generateRandomPassword(10));
		return crepo.save(c);
	}

	public Customer findByAcc(Long accno) throws UserNotFoundException {
//		Optional<Customer> res = crepo.findById(accno);
//		if (res.isPresent())
//			return res.get();
//		return null;
		return crepo.findById(accno)
				.orElseThrow(() -> new UserNotFoundException("user with " + accno + " doesn't exist"));
	}

	public Customer updateCustomer(Customer c, Long accno) throws UserNotFoundException {
		Customer customer = findByAcc(accno);
		customer.setAddress(c.getAddress());
		customer.setName(c.getName());
		customer.setDob(c.getDob());
		return crepo.save(customer);
	}

	public Long deletCustomerById(Long accno) throws UserNotFoundException {
		Customer c = findByAcc(accno);
		Long res = c.getAccno();
		c.setBalance(0);
		crepo.save(c);
		crepo.delete(c);
		return res;
	}

	public Page<Records> getAllRecordsById(Long accno,Pageable p) {
		return rrepo.findByCustomerAccno(accno,p);
	}
	
	public String updatePassword(String password,Long accno) throws UserNotFoundException
	{
		Customer c=findByAcc(accno);
		c.setPassword(password);
		crepo.save(c);
		return "User with Account no "+c.getAccno()+" password update is Success";
		
	}
	
}
