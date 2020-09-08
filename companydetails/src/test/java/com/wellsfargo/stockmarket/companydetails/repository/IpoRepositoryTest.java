package com.wellsfargo.stockmarket.companydetails.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.entity.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doCallRealMethod;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.service.CompanyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyService companyService;

	@InjectMocks
	private CompanyController companyController;
	
	@Before
	public void SetUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testgetMatchingCompanies() throws Exception {
		List<String> mockCompanies = new ArrayList<String>();
		mockCompanies.add("abc");
		mockCompanies.add("abwe");
		when(companyService.getMatchingCompanies(any(String.class))).thenReturn(mockCompanies);
		mockMvc.perform(get("/company/matchingCompanies").param("name","ab"))
		 .andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		 	
	}
	
	@Test
	public void testgetAllCompanies() throws Exception {
		List<Company> companyList = new ArrayList<Company>();
		Company company1 = new Company();
		company1.setCompanyId(1);
		company1.setCompanyCode(1002);
		company1.setCompanyName("abc");
		companyList.add(company1);
		Company company2 = new Company();
		company2.setCompanyId(2);
		company2.setCompanyCode(1003);
		company2.setCompanyName("xyz");
		companyList.add(company2);
		String expected ="[{\"companyId\":1,\"companyName\":\"abc\",\"companyCode\":1002.0,\"ceo\":null,\"boardOfDirs\":null,\"sector\":null,\"companyDetails\":null,\"assocStockExchange\":null},{\"companyId\":2,\"companyName\":\"xyz\",\"companyCode\":1003.0,\"ceo\":null,\"boardOfDirs\":null,\"sector\":null,\"companyDetails\":null,\"assocStockExchange\":null}]";
		when(companyService.getAllCompanies()).thenReturn(companyList);
		mockMvc.perform(get("/company"))
		 .andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		 .andExpect(content().string(expected));
		 	
	}
	

	@Test
	public void testgetOneCompany_success() throws Exception {
		
		Optional<Company> company1 = Optional.of(new Company());
		company1.get().setCompanyId(1);
		company1.get().setCompanyCode(1002);
		company1.get().setCompanyName("abc");
		
		when(companyService.getCompanyByCompanyCode(any(Long.class))).thenReturn(company1);
		mockMvc.perform(get("/company/1"))
		 .andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		 	
	}
	
	@Test
	public void testgetOneCompany_notexist() throws Exception {
	
		when(companyService.getCompanyByCompanyCode(any(Long.class))).thenReturn(null);
		mockMvc.perform(get("/company/9000"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("")).andReturn();
		 	
	}
	
	@Test
	public void testAddCompany() throws Exception {
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/company/addcompany")
				.accept(MediaType.APPLICATION_JSON).content("{\r\n" + 
						"    \"companyName\": \"abc\",\r\n" + 
						"    \"stockExchange\": \"nsc\",\r\n" + 
						"    \"numberOfShares\": 62552,\r\n" + 
						"    \"pricePerShare\": 654,\r\n" + 
						"    \"openDateTime\": \"2020-12-11\",\r\n" + 
						"    \"remarks\": \"asdfg\"\r\n" + 
						"}").contentType(MediaType.APPLICATION_JSON);
		
		Company company1 = new Company();
		company1.setCompanyId(1);
		company1.setCompanyCode(1002);
		company1.setCompanyName("abc");
		
		when(companyService.saveCompany(any(Company.class))).thenReturn(company1);
		mockMvc.perform(reqBuilder)
		 .andExpect(status().isOk())
		 .andReturn();
		 	
	}
	
	@Test
	public void testupdateCompany() throws Exception {
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/company/updatecompany")
				.accept(MediaType.APPLICATION_JSON).content("{\r\n" + 
						"    \"companyName\": \"abc\",\r\n" + 
						"    \"stockExchange\": \"nsc\",\r\n" + 
						"    \"numberOfShares\": 62552,\r\n" + 
						"    \"pricePerShare\": 654,\r\n" + 
						"    \"openDateTime\": \"2020-12-11\",\r\n" + 
						"    \"remarks\": \"asdfg\"\r\n" + 
						"}").contentType(MediaType.APPLICATION_JSON);
		
		Company company1 = new Company();
		company1.setCompanyId(1);
		company1.setCompanyCode(1002);
		company1.setCompanyName("abc");
		
		when(companyService.updateCompany(any(Company.class))).thenReturn(company1);
		mockMvc.perform(reqBuilder)
		 .andExpect(status().isOk())
		 .andReturn();
		 	
	}
	
	@Test
	public void testdeleteCompany() throws Exception {
		Optional<Company> company1 = Optional.of(new Company());
		company1.get().setCompanyId(1);
		company1.get().setCompanyCode(1002);
		company1.get().setCompanyName("abc");
		when(companyService.getCompanyByCompanyCode(any(Long.class))).thenReturn(company1);
		when(companyService.deleteCompany(any(Long.class))).thenReturn(true);
		mockMvc.perform(get("/company/deletecompany/1002"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("Company deleted")).andReturn();
		 
		 	
	}
	
	@Test
	public void testdeleteCompany_error() throws Exception {
		Optional<Company> company1 = Optional.of(new Company());
		company1.get().setCompanyId(1);
		company1.get().setCompanyCode(1002);
		company1.get().setCompanyName("abc");
		when(companyService.getCompanyByCompanyCode(any(Long.class))).thenReturn(company1);
		when(companyService.deleteCompany(any(Long.class))).thenReturn(false);
		mockMvc.perform(get("/company/deletecompany/2002"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("Error occured"))
		 .andReturn();
		 
		 	
		 	
	}
	
	
	
}
