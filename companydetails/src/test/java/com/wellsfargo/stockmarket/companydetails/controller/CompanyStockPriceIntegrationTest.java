package com.wellsfargo.stockmarket.companydetails.controller;


import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;

@SpringBootTest(classes = CompanyDetailsApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class CompanyStockPriceIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void CompanyStockPriceIT() throws JSONException{
		CompanyPeriodModel companyPeriod = new CompanyPeriodModel();
		List<Integer> companyList =new ArrayList<Integer>();
		companyList.add(1002);
		companyPeriod.setCompanyList(companyList);
		companyPeriod.setPeriodicity(3);
		HttpEntity<CompanyPeriodModel> entity = new HttpEntity<CompanyPeriodModel>(companyPeriod, headers);
	//entity.getBody().setCompanyList(companyList);
	//entity.getBody().setPeriodicity(3);
		String resp = this.testRestTemplate
				.exchange("/company/companyStockPrice",
						HttpMethod.POST, entity, String.class).getBody();
		
		
		Assert.assertTrue(resp.length()>0);
				
			
		
	}
	
}
