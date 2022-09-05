package com.estockmarket.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.company.model.Company;
import com.estockmarket.company.service.CompanyService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/register" ,method=RequestMethod.POST)
	public String saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);

	}

	@GetMapping(value = "/getall" )
	List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@RequestMapping(value = "/info/{companyCode}" ,method=RequestMethod.POST)
	public Company getCompanyDetails(@PathVariable String companyCode) {
		return companyService.getCompanyDetails(companyCode);
	}

	@RequestMapping(value = "/delete/{companyCode}",method=RequestMethod.DELETE)
	public String deleteCompanyDetails(@PathVariable String companyCode) {

		return companyService.deleteCompanyDetails(companyCode);
	}

}
