package com.wellsfargo.stockmarket.companydetails.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;
import com.wellsfargo.stockmarket.companydetails.service.CompanyStockPriceService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class CompanyStockPriceController {
	
	@Autowired
	CompanyStockPriceService companyStockPriceService;

	/*
	 * this is the controller which is invoked while getting 
	 * company stock price comparison details
	 * Param: periodicity is in days
	 * companyList is a ',' seperated list of companies
	 * http://localhost:3002/companyStockPrice?inputCompanyList=1&inputFromDate=20/09/2019&inputToDate=20/09/2020
	 * http://localhost:3002/companyStockPrice?inputCompanyList=1&periodicity=1
	 */
		@RequestMapping(path="/company/companyStockPrice")
		public List<CompanyStockPrice> getCompanyStockPriceDetails(@RequestBody CompanyPeriodModel companyPeriod){
			
			
			List<CompanyStockPrice> companyStockPriceList = null;
			if(companyPeriod.getPeriodicity()>0) {
				 LocalDate currentDate = LocalDate.now();
				 companyPeriod.setPeriodToDate(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				 companyPeriod.setPeriodFromDate(Date.from(currentDate.minusDays(companyPeriod.getPeriodicity()).atStartOfDay(ZoneId.systemDefault()).toInstant()));	
			}
			if(companyPeriod.getCompanyList()!=null && companyPeriod.getPeriodFromDate()!=null && companyPeriod.getPeriodToDate()!=null) {
				
				companyStockPriceList = companyStockPriceService.getCompanyDetails(companyPeriod);
			}
			
			
			return companyStockPriceList;
		}
	
		
		
}
