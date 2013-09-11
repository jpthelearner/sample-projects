package com.jp.spring_jdbc.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.jp.spring_jdbc.dao.ShipRequestDao;
import com.jp.war_proj_tmpl.schema.ShipRequest;

@Component
public class ShipRequestDaoImpl extends JdbcDaoSupport implements ShipRequestDao {

	@Autowired
	public ShipRequestDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	  
	@Override
	public void create(ShipRequest shipRequest) {
	    getJdbcTemplate().update(
	    	      "INSERT INTO SHIP_REQUEST (SHIP_REQUEST_ID, FULFILLMENT_PARTY_ID, REQUEST_STATUS_ID, DATE_CREATED, CREATED_BY) VALUES (SHIP_REQUEST_SEQ.NEXTVAL, ?, ?, ?, ?)",
	    	        new Object[] {
	    	    		  shipRequest.getFpId(),
	    	    		  shipRequest.getRequestStatusId(),
	    	    		  new Date(),
	    	    		  shipRequest.getCreatedBy()
	    	      }
	    	    );
	}

	@Override
	public ShipRequest findById(Long id) {
		ShipRequest result = getJdbcTemplate().queryForObject("SELECT * FROM SHIP_REQUEST WHERE SHIP_REQUEST_ID = ?",
	    	      new Object[] { id },
	    	      new ShipRequestMapper());
		return result;
	}


	@Override
	public List<ShipRequest> findByCreatedBy(String createdBy) {
		List<ShipRequest> result = getJdbcTemplate().query("SELECT * FROM SHIP_REQUEST WHERE CREATED_BY = ?",
	    	      new Object[] { createdBy },
	    	      new ShipRequestMapper());
		return result;
	}
	
	private class ShipRequestMapper implements RowMapper<ShipRequest> {

		@Override
		public ShipRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShipRequest shipRequest = new ShipRequest();
			shipRequest.setId(rs.getInt("ship_request_id"));
			shipRequest.setCreatedBy(rs.getString("created_by"));
			//shipRequest.setDateCreated(rs.getDate("date_created"));
			return shipRequest;
		}

	}

}
