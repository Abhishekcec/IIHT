package com.estockmarket.company.service;

import java.util.List;

import com.estockmarket.company.model.Company;

public interface CompanyService {

	String saveCompany(Company company);
	List<Company> getAllCompanies();
	Company getCompanyDetails(String companyCode);
	String deleteCompanyDetails(String companyCode);
}
