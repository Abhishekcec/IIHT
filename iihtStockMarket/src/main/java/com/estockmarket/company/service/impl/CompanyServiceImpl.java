package com.estockmarket.company.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.estockmarket.company.model.Company;
import com.estockmarket.company.repository.CompanyRepository;
import com.estockmarket.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public String saveCompany(Company company) {
		String code = createCompanyCode(company.getCompanyName());
		List<String> companies = companyRepository.findAll().stream().map(Company::getCompanyName).collect(Collectors.toList());
		if(companies.contains(company.getCompanyName()))
		{
			return "Company Already exists";
		}
		else {
			company.setCompanyCode(code);
			if(companyRepository.save(company)!=null) {
				return "Successfully Registered Company";
			}
			else {
				return "Something went wrong";
			}
		}
		
		
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyDetails(String companyCode) {
		return companyRepository.findByCompanyCode(companyCode);
	}

	@Override
	public String deleteCompanyDetails(String companyCode) {
		Company toBeDeletedCompany = companyRepository.findByCompanyCode(companyCode);
		if (null != toBeDeletedCompany) {
			try {
				companyRepository.delete(toBeDeletedCompany);
				return "Company deleted Successfully";
			} catch (Exception e) {
				System.out.print("Exception in deleteCompany"+e);
				return "Something went wrong";
			}
		}else {
			return "Something went wrong-Company does exist in DB";
		}
	}
	
	private String createCompanyCode(String companyName) {
		String companyCode1 = companyName.substring(0, 3).concat("%");
		int count = companyRepository.getCompanyCount(companyCode1);
		String code = String.format("%03d", count);
		
		String companyCode = companyName.substring(0, 3).concat(code);
		System.out.println("final code: "+companyCode );
		return companyCode;
		
	}

}
