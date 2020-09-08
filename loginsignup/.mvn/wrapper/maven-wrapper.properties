package com.wellsfargo.stockmarket.companydetails.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockmarket.companydetails.entity.CompanyPeriodModel;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyStockPriceRepository;

@Service
public class CompanyStockPriceService {

	@Autowired
	CompanyStockPriceRepository companyStockPriceRepository;
	
	public List<CompanyStockPrice> getCompanyDetails(CompanyPeriodModel companyPeriod){
		return companyStockPriceRepository.findByCompanyListBetweenPeriod(companyPeriod.getCompanyList(),companyPeriod.getPeriodFromDate(),companyPeriod.getPeriodToDate());
		
	}
	
	
}
