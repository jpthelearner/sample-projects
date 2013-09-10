package com.jp.spring_data_jpa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.spring_data_jpa.entity.ShipRequest;
import com.jp.spring_data_jpa.repo.ShipRequestRepo;

@Service
public class ShipRequestService {
	
	@Autowired ShipRequestRepo repo;

	@Transactional
	public void create() {
		ShipRequest shipRequest = new ShipRequest();
		shipRequest.setCreatedBy("JP");
		shipRequest.setDateCreated(new Date());
		shipRequest.setFulFillmentPartyId(1L);
		shipRequest.setRequestStatusId(1L);
		repo.save(shipRequest);
		
		//to make transaction fail
		throw new RuntimeException("simulate problems");
	}

}
