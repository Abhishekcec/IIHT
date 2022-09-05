package com.estockmarket.authentication.service;

import java.util.List;

import com.estockmarket.authentication.model.Company;

public interface CompanyService {
	String saveCompany(Company company);
	List<Company> getAllCompanies();
	String deleteCompanyDetails(String companyCode);
}
