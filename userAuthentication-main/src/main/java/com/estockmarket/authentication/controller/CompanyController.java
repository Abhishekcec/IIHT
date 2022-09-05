package com.estockmarket.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.authentication.model.CompanyStock;
import com.estockmarket.authentication.service.impl.CompanyStockServiceImpl;
import com.estockmarket.authentication.model.Company;
import com.estockmarket.authentication.service.CompanyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {
	
	@Autowired
	private CompanyStockServiceImpl companyStockServiceImpl;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/register" ,method=RequestMethod.POST)
	public String saveCompany(@RequestBody Company company) {
		System.out.println("company: "+ company.getCompanyTurnover());
		return companyService.saveCompany(company);

	}
	
	@RequestMapping(value="/info/{companyCode}",method=RequestMethod.POST)
	public CompanyStock getCompanyDetails(@PathVariable String companyCode) {
		System.out.println(companyCode);
		return companyStockServiceImpl.getCompanyDetails(companyCode);
	}
	
	@GetMapping(value = "/getall")
	List<Company> getAllCompanies() {
		System.out.println("request came: ");
		return companyService.getAllCompanies();
	}
	
	@RequestMapping(value = "/delete/{companyCode}",method=RequestMethod.DELETE)
	public String deleteCompanyDetails(@PathVariable String companyCode) {

		return companyService.deleteCompanyDetails(companyCode);
	}

}
