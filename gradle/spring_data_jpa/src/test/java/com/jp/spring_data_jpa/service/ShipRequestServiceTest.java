package com.jp.spring_data_jpa.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.spring_data_jpa.repo.ShipRequestRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springtest/application-context.xml")
public class ShipRequestServiceTest {

	@Autowired ShipRequestService service;
	
	@Test
	public void testCreate() {
		service.create();
	}	

}
