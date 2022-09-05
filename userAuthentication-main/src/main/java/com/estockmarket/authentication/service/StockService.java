package com.estockmarket.authentication.service;

import java.time.LocalDateTime;

import com.estockmarket.authentication.model.Stock;
import com.estockmarket.authentication.model.StockDetails;

public interface StockService {
	
	String saveStock(Stock stock);

	StockDetails getCompanyStockPrice(LocalDateTime newStartDate, LocalDateTime newEndDate, String companyCode);

	StockDetails getStocksByCompanyCode(String companyCode);

}
