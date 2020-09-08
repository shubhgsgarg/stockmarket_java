package com.wellsfargo.stockmarket.companydetails.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyRepository;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyStockPriceRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(CompanyServiceTest.class)
public class CompanyServiceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyRepository companyRepository;

	@InjectMocks
	private CompanyService companyService;
	
	@Before
	public void SetUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testgetMatchingCompanies_S() throws Exception {
		List<String> mockCompanies = new ArrayList<String>();
		mockCompanies.add("abc");
		mockCompanies.add("abwe");		
		when(companyRepository.findByCompanyName(any(String.class))).thenReturn(mockCompanies);
		companyService.getMatchingCompanies("ab");
		verify(companyRepository).findByCompanyName("ab");
		
		   
	}
	
	
	@Test
	public void testgetAllCompanies_S() throws Exception {
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
		when(companyRepository.findAll()).thenReturn(companyList);
		companyService.getAllCompanies();
		verify(companyRepository).findAll();
		 	
	}
	

	@Test
	public void testgetOneCompany_S() throws Exception {
		
		Optional<Company> company1 = Optional.of(new Company());
		company1.get().setCompanyId(1);
		company1.get().setCompanyCode(1002);
		company1.get().setCompanyName("abc");
		
		when(companyRepository.findByCompanyCode(any(Long.class))).thenReturn(company1);
		companyService.getCompanyByCompanyCode(1002);
		verify(companyRepository).findByCompanyCode(1002);
	}
	
	@Test
	public void testAddCompany_S() throws Exception {
		
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
		company1.setCompanyCode(1022);
		company1.setCompanyName("abc");
		
		when(companyRepository.save(any(Company.class))).thenReturn(company1);
		companyService.saveCompany(company1);
		verify(companyRepository).save(company1);
		 	
	}
	
	@Test
	public void testupdateCompany_S() throws Exception {
		
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
		company1.setCompanyCode(1022);
		company1.setCompanyName("abc");
		
		when(companyRepository.save(any(Company.class))).thenReturn(company1);
		companyService.updateCompany(company1);
		verify(companyRepository).save(company1);
		 	
	}
	
	@Test
	public void testdeleteCompany_S() throws Exception {
			
		companyService.deleteCompany(1008);
		
		verify(companyRepository).deleteById(1008l);
   
		 	
	}
}


