package com.bank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entity.Records;
import com.bank.demo.exceptions.InsufficientFundsException;
import com.bank.demo.exceptions.MinBalanceException;
import com.bank.demo.exceptions.UserNotFoundException;
import com.bank.demo.service.RecordService;

@RestController
public class RecordsController {
	@Autowired
	private RecordService service;
	@PostMapping("/record/{accno}")
	public Records saveRecord(@RequestBody Records records,@PathVariable Long accno) throws UserNotFoundException, InsufficientFundsException, MinBalanceException
	{
		return service.saveRecord(records,accno);
		
	}

}
