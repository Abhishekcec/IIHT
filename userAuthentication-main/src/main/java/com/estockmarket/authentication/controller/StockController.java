package com.estockmarket.authentication.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.authentication.model.Stock;
import com.estockmarket.authentication.service.StockService;
import com.estockmarket.authentication.model.StockDetails;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping(value = "/add")
	public String saveCompany(@RequestBody Stock stock) {
		stockService.saveStock(stock);
		return "saved successfully";
	}
	
	@PostMapping("/get/{companyCode}/{startDate}/{endDate}")
	public StockDetails getStock(@PathVariable String companyCode, @PathVariable @DateTimeFormat String startDate, @PathVariable @DateTimeFormat String endDate){
			LocalDateTime newStartDate = LocalDateTime.parse(startDate);
			LocalDateTime newEndDate = LocalDateTime.parse(endDate); 
			return stockService.getCompanyStockPrice(newStartDate, newEndDate, companyCode);
	}

}
