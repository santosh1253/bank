package com.bank.demo.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entity.Records;

public interface RecordRepo extends JpaRepository<Records,Integer> {

	public Page<Records> findByCustomerAccno(Long accno,Pageable p);
}
