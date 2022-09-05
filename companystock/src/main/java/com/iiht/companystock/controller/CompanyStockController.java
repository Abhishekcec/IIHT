package com.iiht.companystock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.companystock.model.CompanyStock;
import com.iiht.companystock.service.impl.CompanyStockServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyStockController {
	
	@Autowired
	private CompanyStockServiceImpl companyStockServiceImpl;
	
	
	@RequestMapping(value="/info/{companyCode}",method=RequestMethod.POST)
	public CompanyStock getCompanyDetails(@PathVariable String companyCode) {
		System.out.println(companyCode);
		return companyStockServiceImpl.getCompanyDetails(companyCode);
	}
	
	

}
