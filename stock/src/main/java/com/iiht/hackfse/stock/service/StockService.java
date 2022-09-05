package com.iiht.hackfse.stock.service;

import java.time.LocalDateTime;

import com.iiht.hackfse.stock.model.Stock;
import com.iiht.hackfse.stock.transformer.StockDetails;

public interface StockService {

	Stock saveStock(Stock stock);

	StockDetails getCompanyStockPrice(LocalDateTime newStartDate, LocalDateTime newEndDate, String companyCode);

	StockDetails getStocksByCompanyCode(String companyCode);
	
	String deleteStocksByCompanyCode(String companyCode);

}
