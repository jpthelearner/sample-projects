package com.jp.spring_data_jpa.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jp.spring_data_jpa.entity.ShipRequest;

@Repository
public interface ShipRequestRepo extends CrudRepository<ShipRequest, Long> {

}
