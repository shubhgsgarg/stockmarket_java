package com.wellsfargo.stockmarket.companydetails.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wellsfargo.stockmarket.companydetails.entity.Company;
import com.wellsfargo.stockmarket.companydetails.entity.Ipo;
import com.wellsfargo.stockmarket.companydetails.repository.IpoRepository;
public class IpoServiceTest {
	IpoRepository rep;
	Ipo ipo;
	
	@BeforeEach
	void setUp() throws Exception {
		rep = mock(IpoRepository.class);
		ipo = mock(Ipo.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		rep = null;
		assertNull(rep);
		ipo = null;
		assertNull(ipo);
	}

	@Test
	void findAllNotNullTest() {
		List<Ipo> check = rep.findAll();
		assertNotNull(check);
		verify(rep).findAll();
	}
	
	@Test
	void findByIdTest() {
		Optional<Ipo> ipoO = Optional.ofNullable(mock(Ipo.class));
		when(rep.findById((long)1)).thenReturn(ipoO);
		
		Optional<Ipo> check = rep.findById((long)1);
		assertEquals(check,ipoO);
		verify(rep).findById((long)1);
		
	}
	
	@Test
	void saveTest() {
	
		when(rep.save(any(Ipo.class))).thenReturn(ipo);
		rep.save(ipo);
		verify(rep).save(ipo);
	}
	
	@Test
	void deleteByIdTest() {
		
		Optional<Ipo> ipoO = Optional.ofNullable(mock(Ipo.class));
			
		rep.deleteById(ipoO.get().getIpoID());
		
		verify(rep).deleteById(ipoO.get().getIpoID());

	}
	
	@Test
	void findByCompanyNameTest() {
		
		List<Ipo> ls = new ArrayList<>();
		ls.add(ipo);
		
		when(rep.findByCompanyName("a")).thenReturn(ls);
		
		List<Ipo> check = rep.findByCompanyName("a");
		assertEquals(check,ls);
		verify(rep).findByCompanyName("a");
	}
}
