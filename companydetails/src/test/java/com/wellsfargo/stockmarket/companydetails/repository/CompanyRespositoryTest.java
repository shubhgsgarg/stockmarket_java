package com.wellsfargo.stockmarket.companydetails.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Assert;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.controller.CompanyStockPriceController;
import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;

@SpringBootTest(classes = CompanyDetailsApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class CompanyIntegrationTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	HttpHeaders headers = new HttpHeaders();
	
	
	@Test
	public void testdeleteCompany() throws Exception {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String resp = this.testRestTemplate
				.exchange("/company/deletecompany/1005",
						HttpMethod.POST, entity, String.class).getBody();
		System.out.print(resp);
		Assert.assertTrue(resp.equals("Company deleted"));
		 	
	}
	
	@Test
	public void testdeleteCompany_notexist() throws Exception {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String resp = this.testRestTemplate
				.exchange("/company/deletecompany/8009",
						HttpMethod.POST, entity, String.class).getBody();
		
		Assert.assertTrue(resp.equals("Company doesnt exist"));
		 	
	}
	
	@Test
	public void getMatchingCompaniesIT() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String resp = this.testRestTemplate
				.exchange("/company/matchingCompanies?name=ab",
						HttpMethod.GET, entity, String.class).getBody();
		
		
		Assert.assertTrue(resp.length()>0);
	}
	
	
	@Test
	public void testgetAllCompaniesIT() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String resp = this.testRestTemplate
				.exchange("/company",
						HttpMethod.GET, entity, String.class).getBody();
		
		Assert.assertTrue(resp.length()>0);
		
	}
	
	@Test
	public void testgetCompanyIT() throws JSONException{
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String resp = this.testRestTemplate
				.exchange("/company/1002",
						HttpMethod.GET, entity, String.class).getBody();
		
		Assert.assertTrue(resp.length()>0);
	}
	
	@Test
	public void testAddCompany() throws Exception {
		
			
		Company company1 = new Company();
		company1.setCompanyCode(2004);
		company1.setCompanyName("ponyta");
		
		HttpEntity<Company> entity = new HttpEntity<Company>(company1, headers);

		String resp = this.testRestTemplate
				.exchange("/company/addcompany",
						HttpMethod.POST, entity, String.class).getBody();
		
		Assert.assertTrue(resp.length()>0);
		
	
	}
	
	@Test
	public void testupdateCompany() throws Exception {
		Company company1 = new Company();
		company1.setCompanyId(3);
		company1.setCompanyCode(1008);
		company1.setCompanyName("ponyta");
		
		HttpEntity<Company> entity = new HttpEntity<Company>(company1, headers);

		String resp = this.testRestTemplate
				.exchange("/company/updatecompany",
						HttpMethod.POST, entity, String.class).getBody();
		
		Assert.assertTrue(resp.length()>0);
	}
	
	

}
