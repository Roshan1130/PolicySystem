package com.policysystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.policysystem.entities.PolicyEntity;

@Repository
@Transactional
public class PolicyRepository {
private EntityManager em;
	
	public void addPolicy(PolicyEntity p) {
		em.persist(p);
	}
	

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
