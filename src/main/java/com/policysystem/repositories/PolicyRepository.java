package com.policysystem.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.policysystem.entities.PolicyEntity;

@Repository
@Transactional
public class PolicyRepository {
private EntityManager em;
	
	public void addPolicy(PolicyEntity p) {
		em.merge(p);
	}
	
	public PolicyEntity findPolicyByPolicyNo(Long policyNo) {
		Query query = em.createQuery("FROM PolicyEntity p where p.policyNo = :pn"); 
		query.setParameter("pn", policyNo);
		PolicyEntity p = (PolicyEntity) query.getSingleResult();
		return p;
	}
	
	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
