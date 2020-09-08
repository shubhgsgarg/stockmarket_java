package com.wellsfargo.stockmarket.companydetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.wellsfargo.stockmarket.companydetails.entity.Ipo;
import com.wellsfargo.stockmarket.companydetails.service.IpoService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class IpoController {
	
	@Autowired
	IpoService ipoService;
	
	@RequestMapping(path="/company/ipo")
public List<Ipo> getAllIpo()
{
	return ipoService.getAllIpos();
	
}
	
	@RequestMapping("/company/ipo/{ipoId}")
	public Optional<Ipo> getOneipo(@PathVariable long ipoId)
	{
		return ipoService.getIpo(ipoId);
		
	}
	
	@RequestMapping("company/ipo/company/{companyName}")
	public List<Ipo> getIpoByCompanyName(@PathVariable String companyName){
		return ipoService.getIpoByCompanyName(companyName);
	}
	
	@RequestMapping("/company/ipo/addipo")
		public Ipo saveipo(@RequestBody Ipo ipo)																	
		{
			return ipoService.saveIpo(ipo);
			
		}
		
			
	@RequestMapping("/company/ipo/deleteipo/{ipoId}")
		public String deleteipo(@PathVariable long ipoId)
		{
		Optional<Ipo> ipo=ipoService.getIpo(ipoId);
		if(ipo!=null)
		{
			if(ipoService.deleteIpo(ipoId))
			return "ipo deleted";
			else
				return "Error occured";
		}
		
			return "ipo doesnt exist";
			
		}
	

	
	
	
	

}
