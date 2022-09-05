package com.estockmarket.authentication.model;


import java.util.List;

public class StockDetails {
	
	private List<Stock> stocks;
	private Double minimumStockPrice;
	private Double maximumStockPrice;
	private Double averageStockPrice;
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public Double getMinimumStockPrice() {
		return minimumStockPrice;
	}
	public void setMinimumStockPrice(Double minimumStockPrice) {
		this.minimumStockPrice = minimumStockPrice;
	}
	public Double getMaximumStockPrice() {
		return maximumStockPrice;
	}
	public void setMaximumStockPrice(Double maximumStockPrice) {
		this.maximumStockPrice = maximumStockPrice;
	}
	public Double getAverageStockPrice() {
		return averageStockPrice;
	}
	public void setAverageStockPrice(Double averageStockPrice) {
		this.averageStockPrice = averageStockPrice;
	}
	public StockDetails(List<Stock> stocks, Double minimumStockPrice, Double maximumStockPrice,
			Double averageStockPrice, List<Stock> stockDetails) {
		super();
		this.stocks = stocks;
		this.minimumStockPrice = minimumStockPrice;
		this.maximumStockPrice = maximumStockPrice;
		this.averageStockPrice = averageStockPrice;
	}
	public StockDetails() {
		super();
	}
	

}

