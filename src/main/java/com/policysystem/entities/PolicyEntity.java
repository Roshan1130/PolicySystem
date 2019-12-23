package com.policysystem.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="policy")
public class PolicyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="policyNo")
	private Long policyNo;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="expireDate")
	private Date expireDate;
	
	@Column(name="price")
	private Integer price;
	
	@OneToMany(mappedBy = "policy", cascade =CascadeType.ALL )
	private List<CoveredVehicles> coveredVehicles;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private CustomerEntity customer;
	
	
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<CoveredVehicles> getCoveredVehicles() {
		return coveredVehicles;
	}

	public void setCoveredVehicles(List<CoveredVehicles> coveredVehicles) {
		this.coveredVehicles = coveredVehicles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Long policyNo) {
		this.policyNo = policyNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
}
