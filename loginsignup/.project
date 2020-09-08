package com.wellsfargo.stockmarket.companydetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockmarket.companydetails.entity.Ipo;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Long> {
	
	@Query("from Ipo where companyname= ?1 order by ipoid")
	public List<Ipo> findByCompanyName(String companyName);
	
	@Query("from Ipo order by opendatetime")
	public List<Ipo> findAll();
 
}
