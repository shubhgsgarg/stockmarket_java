package com.wellsfargo.stockmarket.companydetails.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.wellsfargo.stockmarket.companydetails.entity.Ipo;
import com.wellsfargo.stockmarket.companydetails.service.IpoService;

import static org.mockito.Mockito.*;



public class IpoTest {
	
	@Test
	void getAllIposTest()
	{
		
		IpoService serv = mock(IpoService.class);
		
		List<Ipo> check = serv.getAllIpos();
		assertNotNull(check);
		verify(serv).getAllIpos();
	}
		
	
	@Test
	void getIpoTest() 
	{
		
		IpoService serv = mock(IpoService.class);
		Optional<Ipo> ipo= Optional.ofNullable(mock(Ipo.class));
		when(serv.getIpo(1)).thenReturn(ipo);

		Optional<Ipo> check = serv.getIpo(1);
		assertEquals(check,ipo);
		verify(serv).getIpo(1);
	}
	
	
	@Test
	void getIpoByCompanyCodeTest() 
	{

		IpoService serv = mock(IpoService.class);
		List<Ipo> ipo= new ArrayList<Ipo>();
		ipo.add(mock(Ipo.class));
		when(serv.getIpoByCompanyName(any(String.class))).thenReturn(ipo);
		List<Ipo> check = serv.getIpoByCompanyName("abc");
		assertEquals(check,ipo);
		verify(serv).getIpoByCompanyName("abc");
	}
	

	@Test
	void saveIpoTest() 
	{
		
		IpoService serv = mock(IpoService.class);
		Ipo ipo= mock(Ipo.class);
		when(serv.saveIpo(any(Ipo.class))).thenReturn(ipo);
		serv.saveIpo(ipo);
		verify(serv).saveIpo(ipo);
	}
	

	@Test
	void deleteIpoTest() 
	{
		IpoService serv = mock(IpoService.class);
		Ipo ipo= mock(Ipo.class);
		when(serv.deleteIpo(any(Long.class))).thenReturn(true);
		serv.deleteIpo(ipo.getIpoID());
		verify(serv).deleteIpo(ipo.getIpoID());
	}
}
