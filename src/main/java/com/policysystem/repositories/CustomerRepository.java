package com.policysystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.policysystem.entities.CustomerEntity;

@Repository
@Transactional
public class CustomerRepository {
	
	private EntityManager em;
	
	public CustomerEntity addCustomer(CustomerEntity c) {
		return em.merge(c);
	}
	

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
