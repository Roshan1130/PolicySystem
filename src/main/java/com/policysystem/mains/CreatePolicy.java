package com.policysystem.mains;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.AddressEntity;
import com.policysystem.entities.CustomerEntity;
import com.policysystem.repositories.CustomerRepository;
import com.policysystem.repositories.PolicyRepository;

public class CreatePolicy {

	public static void main(String[] args) {
		// Use Case: 2
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml"); 
		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");
		PolicyRepository pr = (PolicyRepository) ctx.getBean("policyRepository");
		
		//address
		AddressEntity ae1 = new AddressEntity();
		ae1.setStreet1("9335 Lee Highway");
		ae1.setStreet2("Apt 1104");
		ae1.setCity("Fairfax");
		ae1.setState("Virginia");
		ae1.setZip("21343-3455");
		ae1.setType("Mailing");
		
		AddressEntity ae2 = new AddressEntity();
		ae2.setStreet1("9336 Lester Highway");
		ae2.setStreet2("Apt 104");
		ae2.setCity("Fairfax");
		ae2.setState("Virginia");
		ae2.setZip("21343-3455");
		ae2.setType("Residence");
				
		List<AddressEntity> addresses = new ArrayList<AddressEntity>();
		addresses.add(ae1);
		addresses.add(ae2);
		
		
		//customer
		CustomerEntity c1 = new CustomerEntity();
		c1.setName("Roshan Ramtel");
		c1.setEmail("ramtel.1133@gmail.com");
		c1.setGender("M");
		c1.setPhone("+977829129");
		c1.setLastFourSsn("8372");
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR,1995);
		cal1.set(Calendar.MONTH,12);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		Date date = cal1.getTime();
		
		c1.setDate(date);
		c1.setAddresses(addresses);
		
		cr.addCustomer(c1);
		
		//

	}

}
