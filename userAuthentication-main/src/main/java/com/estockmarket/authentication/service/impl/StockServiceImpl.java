package com.estockmarket.authentication.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estockmarket.authentication.model.Company;
import com.estockmarket.authentication.model.Stock;
import com.estockmarket.authentication.model.StockDetails;
import com.estockmarket.authentication.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String saveStock(Stock stock) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Stock> entity = new HttpEntity<Stock>(stock, headers);

		return restTemplate.exchange("http://STOCK-APP/api/v1.0/market/stock/add", HttpMethod.POST, entity,
				String.class).getBody();
		

	}

	@Override
	public StockDetails getCompanyStockPrice(LocalDateTime newStartDate, LocalDateTime newEndDate, String companyCode) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<StockDetails> entity = new HttpEntity<StockDetails>( headers);

		return restTemplate.exchange("http://STOCK-APP/api/v1.0/market/stock/get/"+companyCode+"/" +newStartDate+"/"+newEndDate, HttpMethod.POST, entity,
				StockDetails.class).getBody();
	}

	@Override
	public StockDetails getStocksByCompanyCode(String companyCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
