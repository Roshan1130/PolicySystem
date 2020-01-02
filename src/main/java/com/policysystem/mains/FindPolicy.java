package com.policysystem.mains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.CustomerRepository;
import com.policysystem.repositories.PolicyRepository;

public class FindPolicy {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");
		PolicyRepository pr = (PolicyRepository) ctx.getBean("policyRepository");
		
		PolicyEntity p1 = pr.findPolicyByPolicyNo(25489l);
		System.out.println(p1.toString());
		
	}

}
