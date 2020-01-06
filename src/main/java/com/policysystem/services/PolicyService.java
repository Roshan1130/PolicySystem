package com.policysystem.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	public void renewPolicy() {
	
		List<PolicyEntity>  policiesToBeRenewed =  policyRepository.findExpiredPolicies();
		
		for (PolicyEntity p : policiesToBeRenewed) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 6);
			Date date = cal.getTime();
			p.setStartDate(new Date());
			p.setExpireDate(date);
			
			policyRepository.addPolicy(p);
		}
		
	}
	
}
