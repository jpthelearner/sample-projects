package com.jp.spring_jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jp.war_proj_tmpl.schema.ShipRequest;

@Component
public interface ShipRequestDao {

	public void create(ShipRequest shipRequest);
	public ShipRequest findById(Long id);
	public List<ShipRequest> findByCreatedBy(String createdBy);
}
