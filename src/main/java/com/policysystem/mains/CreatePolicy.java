package com.policysystem.mains;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.AddressEntity;
import com.policysystem.entities.CoveredVehicles;
import com.policysystem.entities.CustomerEntity;
import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.AddressRepository;
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
		
		// date
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 1995);
		cal1.set(Calendar.MONTH, 12);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		Date date = cal1.getTime();

		// customer
		CustomerEntity c1 = new CustomerEntity();
		c1.setName("Mr Ramtel");
		c1.setEmail("ramtel.1133@gmail.com");
		c1.setGender("M");
		c1.setPhone("+977829129");
		c1.setLastFourSsn("8372");
		c1.setDate(date);

		// address 1
		AddressEntity ae1 = new AddressEntity();
		ae1.setStreet1("9335 Leet Highway");
		ae1.setStreet2("Apt 1104");
		ae1.setCity("Fairfax");
		ae1.setState("Virginia");
		ae1.setZip("21343-3455");
		ae1.setType("Mailing");
		ae1.setCustomer(c1);
		
		/*
		 * List<AddressEntity> addresses = new ArrayList<AddressEntity>();
		 * addresses.add(ae1); ar.addAddress(ae1);
		 */

		
		// address 2
		AddressEntity ae2 = new AddressEntity();
		ae2.setStreet1("9336 Lester Highway");
		ae2.setStreet2("Apt 1040");
		ae2.setCity("Fairfax");
		ae2.setState("Virginia");
		ae2.setZip("21343-3455");
		ae2.setType("Residence");
		ae2.setCustomer(c1);

		/*
		 * List<AddressEntity> addresses2 = new ArrayList<AddressEntity>();
		 * addresses.add(ae2); ar.addAddress(ae2);
		 * 
		 * c1.setAddresses(addresses2);
		 */
		
		// Policy Entity
		PolicyEntity policy = new PolicyEntity();
		policy.setType("Vehicle Insurance");
		policy.setPrice(2000);
		policy.setPolicyNo(23489l);
		policy.setStartDate(new Date());
		policy.setExpireDate(new Date());
		policy.setCustomer(c1);

					
		// coveredVehicles
		CoveredVehicles cv = new CoveredVehicles();
		cv.setMake("Toyota");
		cv.setModel("Camry");
		cv.setVin("xjhf59873r148");
		cv.setYear(2005);
		cv.setColor("Yellow");
		cv.setPolicy(policy);
		
	
		
		
		cr.addCustomer(c1);
		System.out.println("customer added");
		ar.addAddress(ae1);
		System.out.println("1st address done");
		ar.addAddress(ae1);
		
		System.out.println("2nd address done");
		//pr.addPolicy(policy);


		
		
		/*
		 * cvr.addVehicle(cv);
		 * 
		 * pr.addPolicy(policy);
		 */


		
		//
		/*
		 * List<CoveredVehicles> coveredVehicles = new ArrayList<CoveredVehicles>();
		 * coveredVehicles.add(cv);
		 * 
		 * // set vehicle to the policy policy.setCoveredVehicles(coveredVehicles);
		 * 
		 * List<PolicyEntity> policies = new ArrayList<PolicyEntity>();
		 * policies.add(policy);
		 * 
		 * 
		 * //set policy to customer c1.setPolicies(policies); // add customer
		 * pr.addPolicy(policy);
		 */

		}

}
