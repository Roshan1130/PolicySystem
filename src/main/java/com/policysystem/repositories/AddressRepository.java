package com.policysystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.policysystem.entities.AddressEntity;
import com.policysystem.entities.PolicyEntity;

@Repository
@Transactional
public class AddressRepository {
private EntityManager em;
	
	public void addAddress(AddressEntity a) {
		em.merge(a);
	}
	

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
