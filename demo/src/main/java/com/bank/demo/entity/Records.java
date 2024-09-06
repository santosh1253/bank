package com.bank.demo.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Records {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int tid;
	private int recType;
	private double amount;
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_no")
	@JsonIgnore
	private Customer customer;
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getRecType() {
		return recType;
	}

	public void setRecType(int recType) {
		this.recType = recType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Records(int tid, int recType, double amount, Date date) {
		super();
		this.tid = tid;
		this.recType = recType;
		this.amount = amount;
		this.date = date;
	}

	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Records [tid=" + tid + ", recType=" + recType + ", amount=" + amount + ", date=" + date + ", customer="
				+ customer + "]";
	}



}
