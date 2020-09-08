package com.wellsfargo.stockmarket.companydetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.entity.Ipo;
import com.wellsfargo.stockmarket.companydetails.repository.IpoRepository;

@Service
public class IpoService {

	@Autowired
	IpoRepository iporepository;
	
	public List<Ipo> getAllIpos()
	{
		return iporepository.findAll();
		
	}
	
	
	public Optional<Ipo> getIpo(long ipoId)
	{
		return iporepository.findById(ipoId);
		
	}
	
	
	public Ipo saveIpo(Ipo ipo)
	{
		return iporepository.save(ipo);
		
	}
	
	
	
	public boolean deleteIpo(long ipoID)
	{
		iporepository.deleteById(ipoID);
		Optional<Ipo> ipo = iporepository.findById(ipoID);
		if(ipo.isPresent())
		return true;
		return false;
		
	}
	
	
	public List<Ipo> getIpoByCompanyName(String companyName){
		return iporepository.findByCompanyName(companyName);
	}
	
}
