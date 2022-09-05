package com.estockmarket.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.estockmarket.authentication.model.Company;
import com.estockmarket.authentication.model.CompanyStock;
import com.estockmarket.authentication.model.StockDetails;
import com.estockmarket.authentication.service.CompanyStockService;

@Service
public class CompanyStockServiceImpl implements CompanyStockService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public CompanyStock getCompanyDetails(String companyCode) {
		System.out.print(companyCode);

		CompanyStock companyStock = webClientBuilder.build().post()
				.uri("http://COMPANY-STOCK-APP/api/v1.0/market/company/info/" + companyCode).retrieve()
				.bodyToMono(CompanyStock.class).block();

		return companyStock;

	}

}
