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

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.controller.CompanyStockPriceController;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyStockPriceRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(CompanyStockPriceServiceTest.class)
public class CompanyStockPriceServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyStockPriceRepository companyStockPriceRepository;

	@InjectMocks
	private CompanyStockPriceService companyStockPriceService;
	
	@Before
	public void SetUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetCompanyStockPrice_S() throws Exception {
		List<CompanyStockPrice> companyStockPriceList = new ArrayList<CompanyStockPrice>();
		CompanyStockPrice companyStockPrice = mock(CompanyStockPrice.class);
		companyStockPrice.setStockExchange("nsc");
		companyStockPrice.setCurrentPrice(10.2);
		companyStockPriceList.add(companyStockPrice);
		CompanyPeriodModel companyPeriod = mock(CompanyPeriodModel.class);
		List<Integer> compList = new ArrayList<>();
		compList.add(1);
		companyPeriod.setCompanyList(compList);
		companyPeriod.setPeriodicity(1);
		when(companyStockPriceRepository.findByCompanyListBetweenPeriod(any(List.class),any(Date.class),any(Date.class))).thenReturn(companyStockPriceList);
		companyStockPriceService.getCompanyDetails(companyPeriod);
		verify(companyStockPriceRepository).findByCompanyListBetweenPeriod(companyPeriod.getCompanyList(),companyPeriod.getPeriodFromDate(),companyPeriod.getPeriodToDate());
		
		   
	}

}
