package com.iiht.companystock.model;


public class CompanyStock {

	private Company company;
	
	private StockDetails stockDetails;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockDetails getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(StockDetails stockDetails) {
		this.stockDetails = stockDetails;
	}

	public CompanyStock(Company company, StockDetails stockDetails) {
		super();
		this.company = company;
		this.stockDetails = stockDetails;
	}

	public CompanyStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
