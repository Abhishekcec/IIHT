package com.estockmarket.authentication.model;

public class Company {

	private String id;

	private String companyCode;

	private String companyName;

	private String companyCEO;

	private String companyWebsite;

	private Double companyTurnover;

	private String relatedStock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public Double getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(Double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getRelatedStock() {
		return relatedStock;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setRelatedStock(String relatedStock) {
		this.relatedStock = relatedStock;
	}

}