package com.wellsfargo.stockmarket.companydetails.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.service.CompanyService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	//To get the suggestions for auto-complete company name feature
	@RequestMapping(path="company/matchingCompanies")
	public List<String> getMatchingCompanies(@RequestParam(required=false) String name) {
		
		return companyService.getMatchingCompanies(name);
	}
	
	@RequestMapping("/company")
	public List<Company> getAllCompany()
	{
		return companyService.getAllCompanies();
		
	}
	
	
	@RequestMapping("/company/{companyCode}")
	public Optional<Company> getCompany(@PathVariable long companyCode)
	
	{
		return companyService.getCompanyByCompanyCode(companyCode);
		
	}
	
	
	@RequestMapping("/company/addcompany")
		public Company saveCompany(@RequestBody Company company)
																			
		{
			return companyService.saveCompany(company);
			
		}
		
		
	@RequestMapping("/company/updatecompany")
		public Company updateCompany(@RequestBody Company comp)
		{
		 	return companyService.updateCompany(comp);
		
		}
		
	@RequestMapping("/company/deletecompany/{companycode}")
		public List<String> deleteCompany(@PathVariable long companycode)
		{
		List<String> map1 = new ArrayList<String>();
		
		
		Optional<Company> company=companyService.getCompanyByCompanyCode(companycode);
		if(company.isPresent())
		{
			if(companyService.deleteCompany(company.get().getCompanyId()))
			map1.add("SUCCESS");
			else
				map1.add("Error occured");
		}
		else
			 map1.add("Company doesnt exist");
			
		
	
	return map1;
		}
	
	
}
