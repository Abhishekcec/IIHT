package com.iiht.hackfse.stock.transformer;

import java.util.List;

import com.iiht.hackfse.stock.model.Stock;

public class StockDetails {
	
	private List<Stock> stocks;
	private Double minimumStockPrice;
	private Double maximumStockPrice;
	private Double averageStockPrice;
	

	public List<Stock> getstocks() {
		return stocks;
	}

	public void setstocks(List<Stock> stocks) {
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
			Double averageStockPrice) {
		super();
		this.stocks = stocks;
		this.minimumStockPrice = minimumStockPrice;
		this.maximumStockPrice = maximumStockPrice;
		this.averageStockPrice = averageStockPrice;
	}

	public StockDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

}
