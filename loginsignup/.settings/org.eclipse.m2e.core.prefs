package com.wellsfargo.stockmarket.companydetails.entity;

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
@Table(name="ipo")
public class Ipo {

	@Id
	@Column(name="ipoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ipoID;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="stockexchange")
	private String stockExchange;
	
	@Column(name="totalshare")
	private double numberOfShares;
	
	@Column(name="pricepershare")
	private double pricePerShare;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name="opendatetime")
	private Date openDateTime;
	
	@Column(name="remarks")
	private String remarks;

	public Ipo() {
		
	}
	
	public long getIpoID() {
		return ipoID;
	}

	public void setIpoID(long ipoID) {
		this.ipoID = ipoID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public double getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Date getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
