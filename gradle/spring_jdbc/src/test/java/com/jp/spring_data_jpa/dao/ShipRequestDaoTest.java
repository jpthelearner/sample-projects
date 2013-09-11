package com.jp.spring_data_jpa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jp.spring_jdbc.dao.ShipRequestDao;
import com.jp.war_proj_tmpl.schema.ShipRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springtest/application-context.xml")
public class ShipRequestDaoTest {

	@Autowired ShipRequestDao dao;

	@Test
	public void testCreate() {
		ShipRequest shipRequest = new ShipRequest();
		shipRequest.setFpId(1L);
		shipRequest.setRequestStatusId(0L);
		shipRequest.setCreatedBy("JP");
		dao.create(shipRequest);
	}	
	
	@Test
	public void testFindByCreatedBy() {
		Assert.assertNotEquals(dao.findByCreatedBy("SATS").size(), 0);
	}	
	
	@Test
	public void testFindById() {
		Assert.assertNotNull(dao.findById(910L));
	}	

}
