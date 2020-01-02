package com.policysystem.mains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.AddressEntity;
import com.policysystem.entities.CustomerEntity;
import com.policysystem.entities.PolicyEntity;
import com.policysystem.repositories.AddressRepository;
import com.policysystem.repositories.CustomerRepository;
import com.policysystem.repositories.PolicyRepository;

public class ChangeAddress {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");
		PolicyRepository pr = (PolicyRepository) ctx.getBean("policyRepository");
		
		PolicyEntity p1 = pr.findPolicyByPolicyNo(25489l);
		//System.out.println(p1.toString());
		
		CustomerEntity c1 = p1.getCustomer();
		
		List<AddressEntity> addresses = new ArrayList<AddressEntity>();
		AddressEntity address1 = new AddressEntity();

		findAddressEntities(c1.getId());

		address1.setCity("Fairfax");
		address1.setState("Virginia");
		address1.setStreet1("93 ssee highway");
		address1.setStreet2("Apt 1105");
		address1.setType("Home");
		address1.setZip("7483-4589");
		address1.setCustomer(c1);
		
		addresses.add(address1);
		
		c1.setAddresses(addresses);
		
		AddressRepository ar = (AddressRepository) ctx.getBean("addressRepository");
		cr.addCustomer(c1);
		}

}
