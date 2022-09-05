package com.iiht.companystock.model;

import java.time.LocalDateTime;

public class Stock {
	private String id;
	private String companyCode;
	private double price;
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

	

}
