package com.wellsfargo.stockmarket.companydetails.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stockmarket.companydetails.CompanyDetailsApplication;
import com.wellsfargo.stockmarket.companydetails.service.CompanyServiceTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CompanyDetailsApplication.class)
@WebMvcTest(CompanyRespositoryTest.class)
public class CompanyRespositoryTest {
	
	
	
	@Test
	public void testgetMatchingCompanies_R() throws Exception {
		
		CompanyRepository comprepo = mock(CompanyRepository.class);
		List<String> resp = comprepo.findByCompanyName("ab");
		verify(comprepo).findByCompanyName("ab");
	   
	}
	
	@Test
	public void testfindByCompanyCode_R() throws Exception {
		
		CompanyRepository comprepo = mock(CompanyRepository.class);
		comprepo.findByCompanyCode(1002);
		verify(comprepo).findByCompanyCode(1002);
	   
	}

}
