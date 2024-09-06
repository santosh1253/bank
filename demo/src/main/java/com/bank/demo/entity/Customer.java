package com.bank.demo.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accno;
	private String acctype;
	@Column(nullable = false)
	private double balance;
	@Column(nullable = false)
	private Date dob;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private Long mbno;
	@Column(nullable = false,unique=true)
	private String email;
	@Column(nullable = false,unique=true)
	private String idproof;
	@Column(nullable = false)
	@JsonIgnore
	private String password;
	@OneToMany(mappedBy = "customer", targetEntity = Records.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Records> records;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMbno() {
		return mbno;
	}

	public void setMbno(Long mbno) {
		this.mbno = mbno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	public Customer(String name, long accno, String acctype, double balance, Date dob, String address, long mbno,
			String email, String idproof, String password) {
		super();
		this.name = name;
		this.accno = accno;
		this.acctype = acctype;
		this.balance = balance;
		this.dob = dob;
		this.address = address;
		this.mbno = mbno;
		this.email = email;
		this.idproof = idproof;
		this.password = password;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", accno=" + accno + ", acctype=" + acctype + ", balance=" + balance
				+ ", dob=" + dob + ", address=" + address + ", mbno=" + mbno + ", email=" + email + ", idproof="
				+ idproof + ", password=" + password + "]";
	}

}
