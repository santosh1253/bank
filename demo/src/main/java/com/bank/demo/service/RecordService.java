package com.bank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entity.Customer;
import com.bank.demo.entity.Records;
import com.bank.demo.exceptions.InsufficientFundsException;
import com.bank.demo.exceptions.MinBalanceException;
import com.bank.demo.exceptions.UserNotFoundException;
import com.bank.demo.repo.RecordRepo;

@Service
public class RecordService {

	@Autowired
	private RecordRepo recordRepo;
	@Autowired
	private CustomerService cs;

	public Records saveRecord(Records r, Long accno) throws UserNotFoundException, InsufficientFundsException, MinBalanceException {
		Customer res = cs.findByAcc(accno);
		r.setCustomer(res);
		//deposit
		if(r.getRecType()==1)
		{
			double currBalnc=res.getBalance();
			currBalnc+=r.getAmount();
			res.setBalance(currBalnc);
		}
		//withdrawl
		else if(r.getRecType()==2)
		{
			double currBalnc=res.getBalance();
			if(currBalnc<r.getAmount())
			{
				throw new InsufficientFundsException("Insufficient Funds");
			}
			else
			{
				currBalnc-=r.getAmount();
				res.setBalance(currBalnc);
			}
		}	
		cs.saveCustomer(res);
		return recordRepo.save(r);
	}

}
