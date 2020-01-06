package com.policysystem.mains;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.services.PolicyService;

public class RenewPolicy {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		PolicyService service = (PolicyService) ctx.getBean("policyService");
		service.renewPolicy();
	}

}
