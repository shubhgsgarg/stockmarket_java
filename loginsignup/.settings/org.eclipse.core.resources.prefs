package com.wellsfargo.stockmarket.companydetails.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.wellsfargo.stockmarket.companydetails.entity.CompanyStockPrice;

@Repository
public interface CompanyStockPriceRepository extends CrudRepository<CompanyStockPrice, None> {


@Query("from CompanyStockPrice s where "
		+ "s.companyCode in :companyList and s.stockPriceDate BETWEEN :inputFromDate AND :inputToDate")
public List<CompanyStockPrice> findByCompanyListBetweenPeriod(List<Integer> companyList, Date inputFromDate, Date inputToDate);

}
