package com.wellsfargo.stockmarket.companydetails.repository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.entity.Ipo;
import com.wellsfargo.stockmarket.companydetails.service.CompanyServiceTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(IpoRepositoryTest.class)
public class IpoRepositoryTest {

	@Test
	public void testfindByCompnayName_R() throws Exception {
		
		IpoRepository iporepo = mock(IpoRepository.class);
		 iporepo.findByCompanyName("abc");
		verify(iporepo).findByCompanyName("abc");
	   
	}
	
	@Test
	public void testfindAll_R() throws Exception {
		
		IpoRepository iporepo = mock(IpoRepository.class);
		 iporepo.findAll();
		verify(iporepo).findAll();
	   
	}
	
}
