package com.wellsfargo.stockmarket.companydetails.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockmarket.companydetails.entity.AssocStockExchange;
import com.wellsfargo.stockmarket.companydetails.entity.BoardOfDir;
import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.repository.CompanyRepository;
/*
 * @author
 * Team1
 * 
 */


@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;
		
	
	public List<String> getMatchingCompanies(String name){
		
		return companyRepository.findByCompanyName(name);
	}
	
	public List<Company> getAllCompanies()
	{
		return companyRepository.findAll();
		
	}
	
	
	public Optional<Company> getCompanyByCompanyCode(double companyCode)
	{
		return companyRepository.findByCompanyCode(companyCode);
		
	}
	
	
	public Company saveCompany(Company inputCompnay)
	{
		Company inputToSaveCompany= new Company();
		inputToSaveCompany.setBoardOfDirs(inputCompnay.getBoardOfDirs());
		inputToSaveCompany.setAssocStockExchange(inputCompnay.getAssocStockExchange());
		inputToSaveCompany.setCompanyCode(inputCompnay.getCompanyCode());
		inputCompnay.setAssocStockExchange(null);
		inputCompnay.setBoardOfDirs(null);
		Company company = companyRepository.save(inputCompnay);
		//company.setBoardOfDirs(inputToSaveCompany.getBoardOfDirs());
		//company.setAssocStockExchange(inputToSaveCompany.getAssocStockExchange());
		//updateCompany(company);
		return company;
	}
	
	
	
	public Company updateCompany(Company inputCompnay)
	{
		Optional<Company> comp=companyRepository.findByCompanyCode(inputCompnay.getCompanyCode());
		if(comp.isPresent()) {
			System.out.print(comp);
		comp.get().setCeo(inputCompnay.getCeo());
		comp.get().setCompanyDetails(inputCompnay.getCompanyDetails());
		comp.get().setSector(inputCompnay.getSector());
		List<AssocStockExchange> listtemp = new ArrayList<>();
		if(inputCompnay.getAssocStockExchange()!=null) {
			for(AssocStockExchange element: inputCompnay.getAssocStockExchange()) {
				if(element.getStockcode().length()>0) {
					element.setAssoccompanycode(comp.get().getCompanyCode());
					listtemp.add(element);
					}
			}
			if(listtemp.size()>0)
		comp.get().setAssocStockExchange(listtemp);
		
		}
		if(inputCompnay.getBoardOfDirs()!=null) {
			List<BoardOfDir> listboard = new ArrayList<BoardOfDir>();
			for(BoardOfDir element1: inputCompnay.getBoardOfDirs()) {
				if(element1.getBoardOfDirName().length()>0) {
					listboard.add(element1);
					}
			}
			if(listboard.size()>0)
		comp.get().setBoardOfDirs(listboard);
		}
		
		return companyRepository.save(comp.get());
		}
		return null;
		
	}
	
	
	public boolean deleteCompany(long companyId)
	{
		companyRepository.deleteById(companyId);
		Optional<Company> company = companyRepository.findById(companyId);
		if(company.isPresent())
		return false;
		return true;
	}
	
	
	
	
	
	
}
