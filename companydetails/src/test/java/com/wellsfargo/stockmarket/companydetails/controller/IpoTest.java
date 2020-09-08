package com.wellsfargo.stockmarket.companydetails.controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.controller.CompanyController;
import com.wellsfargo.stockmarket.companydetails.controller.CompanyStockPriceController;
import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;
import com.wellsfargo.stockmarket.companydetails.service.CompanyService;
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
import com.wellsfargo.stockmarket.companydetails.service.CompanyStockPriceService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(CompanyStockPriceController.class)
public class CompanyStockPriceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyStockPriceService companyStockPriceService;

	@InjectMocks
	private CompanyStockPriceController companyStockPriceController;
	
	@Before
	public void SetUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetCompanyStockPrice() throws Exception {
		List<CompanyStockPrice> companyStockPriceList = new ArrayList<CompanyStockPrice>();
		CompanyStockPrice companyStockPrice = new CompanyStockPrice();
		companyStockPrice.setStockExchange("nsc");
		companyStockPrice.setCurrentPrice(10.2);
		companyStockPriceList.add(companyStockPrice);
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/company/companyStockPrice")
				.accept(MediaType.APPLICATION_JSON).content("{\r\n" + 
						"    \"companyList\":[1002],\r\n" + 
						"    \"periodFromDate\": \"2020-02-02\",\r\n" + 
						"    \"periodToDate\" : \"2020-11-28\"\r\n" + 
						"\r\n" + 
						"}").contentType(MediaType.APPLICATION_JSON);
	
		
		
		when(companyStockPriceService.getCompanyDetails(any(CompanyPeriodModel.class))).thenReturn(companyStockPriceList);
		
			mockMvc.perform(reqBuilder)
		 .andExpect(status().isOk())
		 .andReturn();
		
		   
	}
	
	
	
}
