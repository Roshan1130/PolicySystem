package com.policysystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.policysystem.entities.CoveredVehicles;
import com.policysystem.entities.PolicyEntity;

@Repository
@Transactional
public class CoveredVehiclesRepository {
private EntityManager em;
	
	public void addVehicle(CoveredVehicles cv) {
		em.merge(cv);
	}
	

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
