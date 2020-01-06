package com.policysystem.mains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.repositories.CoveredDriversRepository;
import com.policysystem.repositories.PolicyRepository;

public class InsertDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CoveredDriversRepository cdr = (CoveredDriversRepository) context.getBean("driversRepsoitory");
		PolicyRepository porep = (PolicyRepository) context.getBean("policyRepository");
		AdditionalDriversEntity driver = new AdditionalDriversEntity();
		driver.setActive(true);
		driver.setIssuedState("Virginia");
		driver.setLicenseNo("A12347658");
		driver.setName("Manoj");
		driver.setPolicy(porep.getByID(1l));
		driverrep.saveDriverEntity(driver);

		driver.setActive(true);
		driver.setIssuedState("Virginia");
		driver.setLicenseNo("A12345hsh");
		driver.setName("Roshan Ramtel");
		driver.setPolicy(porep.getByID(1l));
		driverrep.saveDriverEntity(driver);

	}

}
