package com.wellsfargo.stockmarket.companydetails.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

@Configuration
public class CompanyPeriodModel {

	private List<Integer> companyList;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date periodToDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date periodFromDate;
	
	//period in number of days
	private int periodicity;

	public CompanyPeriodModel() {
		
	}
	
	public List<Integer> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Integer> companyList) {
		this.companyList = companyList;
	}

	public Date getPeriodToDate() {
		return periodToDate;
	}

	public void setPeriodToDate(Date periodToDate) {
		this.periodToDate = periodToDate;
	}

	public Date getPeriodFromDate() {
		return periodFromDate;
	}

	public void setPeriodFromDate(Date periodFromDate) {
		this.periodFromDate = periodFromDate;
	}

	public int getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(int periodicity) {
		this.periodicity = periodicity;
	}
	
	
}
