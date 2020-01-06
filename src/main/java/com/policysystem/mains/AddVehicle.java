package com.policysystem.mains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.CoveredVehicles;
import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.CoveredVehiclesRepository;
import com.policysystem.repositories.PolicyRepository;

public class AddVehicle {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		CoveredVehiclesRepository cvr = (CoveredVehiclesRepository) context.getBean("coveredVehiclesRepository");
		PolicyRepository pr = (PolicyRepository) context.getBean("policyRepository");
		CoveredVehicles cve = new CoveredVehicles();

		PolicyEntity p1 = pr.findPolicyByPolicyNo(25480l);
		
		//adding a new vehicle
		cve.setIsActive(true);
		cve.setMake("Toyota");
		cve.setModel("Camry");
		cve.setVin("657236478g2387462378gg");
		cve.setYear(2017);
		cve.setPolicy(p1);
		cvr.addVehicle(cve);
		
		
		//deleting a vehicle
		
	}

}
