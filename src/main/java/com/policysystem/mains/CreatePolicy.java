package com.policysystem.mains;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.AddressEntity;
import com.policysystem.entities.CoveredDrivers;
import com.policysystem.entities.CoveredVehicles;
import com.policysystem.entities.CustomerEntity;
import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.AddressRepository;
import com.policysystem.repositories.CoveredDriversRepository;
import com.policysystem.repositories.CoveredVehiclesRepository;
import com.policysystem.repositories.CustomerRepository;
import com.policysystem.repositories.PolicyRepository;

public class CreatePolicy {

	public static void main(String[] args) {
		// Use Case: 2

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");
		PolicyRepository pr = (PolicyRepository) ctx.getBean("policyRepository");
		AddressRepository ar = (AddressRepository) ctx.getBean("addressRepository");
		CoveredVehiclesRepository cvr = (CoveredVehiclesRepository) ctx.getBean("coveredVehiclesRepository");
		CoveredDriversRepository cdr = (CoveredDriversRepository) ctx.getBean("coveredDriversRepository");
		
		// date
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 1995);
		cal1.set(Calendar.MONTH, 12);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		Date date = cal1.getTime();

		// customer
		CustomerEntity c1 = new CustomerEntity();
		c1.setName("Mr Hari");
		c1.setEmail("ramt944.1133@gmail.com");
		c1.setGender("M");
		c1.setPhone("+48782901282");
		c1.setLastFourSsn("8371");
		c1.setDate(date);
		
		c1=cr.addCustomer(c1);
		

		// address 1
		AddressEntity ae1 = new AddressEntity();
		ae1.setStreet1("9335 Heet Highway");
		ae1.setStreet2("Apt 1104");
		ae1.setCity("Fairfax");
		ae1.setState("Virginia");
		ae1.setZip("21343-3455");
		ae1.setType("Mailing");
		ae1.setCustomer(c1);

		// address 2
		AddressEntity ae2 = new AddressEntity();
		ae2.setStreet1("9336 Hester Highway");
		ae2.setStreet2("Apt 1040");
		ae2.setCity("Fairfax");
		ae2.setState("Virginia");
		ae2.setZip("21343-3455");
		ae2.setType("Residence");
		ae2.setCustomer(c1);
		
		System.out.println("inserting add 1...");
		ar.addAddress(ae1);
		
		System.out.println("inserting add2...");
		ar.addAddress(ae2);


		// Policy Entity
		PolicyEntity policy = new PolicyEntity();
		policy.setType("Vehicle Insurance");
		policy.setPrice(2000);
		policy.setPolicyNo(25480l);
		policy.setStartDate(new Date());
		policy.setExpireDate(new Date());
		policy.setCustomer(c1);
		
		
	 List<CoveredVehicles> vehicles =  new ArrayList<CoveredVehicles>();

		// coveredVehicles
		CoveredVehicles cv = new CoveredVehicles();
		cv.setMake("Toyota");
		cv.setModel("Camry");
		cv.setVin("ajro8ro873r168");
		cv.setYear(2005);
		cv.setColor("Yellow");
		cv.setPolicy(policy);
				
		vehicles.add(cv);
		policy.setCoveredVehicles(vehicles);
		
		 List<CoveredDrivers> drivers = new ArrayList<CoveredDrivers>();
		 
		  CoveredDrivers cd = new CoveredDrivers(); 
		  cd.setLicenseNo("dkijf83");
		  cd.setLicenseState("MD"); 
		  cd.setName("Sumi"); 
		  cd.setPolicy(policy);
		 
		 System.out.println("inserting drivers");
		  
		  drivers.add(cd); 
		  policy.setCoveredDrivers(drivers);
		
		  System.out.println("adding policy...");
			pr.addPolicy(policy);
			
		

	}

}
