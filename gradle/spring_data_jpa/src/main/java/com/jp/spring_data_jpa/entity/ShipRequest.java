package com.jp.spring_data_jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="SHIP_REQUEST")
public class ShipRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long getShipRequestId() {
		return shipRequestId;
	}

	public void setShipRequestId(Long shipRequestId) {
		this.shipRequestId = shipRequestId;
	}

	public Long getFulFillmentPartyId() {
		return fulFillmentPartyId;
	}

	public void setFulFillmentPartyId(Long fulFillmentPartyId) {
		this.fulFillmentPartyId = fulFillmentPartyId;
	}

	public Long getRequestStatusId() {
		return requestStatusId;
	}

	public void setRequestStatusId(Long requestStatusId) {
		this.requestStatusId = requestStatusId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Id
	@SequenceGenerator(name="SHIP_REQ_ID_GENERATOR", sequenceName="SHIP_REQUEST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIP_REQ_ID_GENERATOR")	
	@Column(name="SHIP_REQUEST_ID")
	private Long shipRequestId;
	
	
	@Column(name="FULFILLMENT_PARTY_ID")
	private Long fulFillmentPartyId;

	
	@Column(name="REQUEST_STATUS_ID")
	private Long requestStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATED")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_MODIFIED")
	private Date dateModified;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	
}

