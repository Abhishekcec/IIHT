package com.estockmarket.authentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estockmarket.authentication.model.Company;
import com.estockmarket.authentication.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String saveCompany(Company company) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);

		return restTemplate
				.exchange("http://COMPANY-APP/api/v1.0/market/company/register", HttpMethod.POST, entity, String.class)
				.getBody();

	}

	@Override
	public List<Company> getAllCompanies() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		ResponseEntity<List<Company>> rateResponse = restTemplate.exchange(
				"http://COMPANY-APP/api/v1.0/market/company/getall", HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<Company>>() {
				});

		return rateResponse.getBody();
	}

	@Override
	public String deleteCompanyDetails(String companyCode) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		ResponseEntity<String> companyResponse = restTemplate.exchange(
				"http://COMPANY-APP/api/v1.0/market/company/delete/" + companyCode, HttpMethod.DELETE, requestEntity,
				String.class);

		ResponseEntity<String> stockResponse = restTemplate.exchange(
				"http://STOCK-APP/api/v1.0/market/stock/delete/" + companyCode, HttpMethod.DELETE, requestEntity,
				String.class);
		return companyResponse.getBody() + " and " + stockResponse.getBody();
	}

}
