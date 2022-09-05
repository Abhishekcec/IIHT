package com.iiht.hackfse.stock.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id")
	private String id;
	
	@Column(name="company_code")
	private String companyCode;
	
	@Column(name="price")
	private double price;
	
	@Column(name="date")
	private LocalDateTime date;
	
	
	public Stock(String id, String companyCode, double price, LocalDateTime date) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.price = price;
		this.date = date;
	}

	public Stock() {
		super();
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString()
	{
		return getCompanyCode() + getId() +getPrice() + getDate();
	}

}
