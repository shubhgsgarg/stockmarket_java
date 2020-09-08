package com.wellsfargo.stockmarket.companydetails.entity;


import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="companystockprice")
public class CompanyStockPrice {

	@Id
	@Column(name="companystockpriceid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyStockPriceId;
	
	@Column(name="companycode")
	private int companyCode;
	
	@Column(name="stockexchange")
	private String stockExchange;
	
	@Column(name="currentprice")
	private double currentPrice;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name="stockpricedate")
	private Date stockPriceDate;
	
	@Column(name="stockpricetime")
	private LocalTime stockPriceTime;
	
	public CompanyStockPrice() {
		
	}
	
	public int getCompanyStockPriceId() {
		return companyStockPriceId;
	}

	public void setCompanyStockPriceId(int companyStockPriceId) {
		this.companyStockPriceId = companyStockPriceId;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getDate() {
		return stockPriceDate;
	}

	public void setDate(Date stockPriceDate) {
		this.stockPriceDate = stockPriceDate;
	}

	public LocalTime getTime() {
		return stockPriceTime;
	}

	public void setTime(LocalTime stockPriceTime) {
		this.stockPriceTime = stockPriceTime;
	}
	
}
