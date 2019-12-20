package com.policysystem.mains;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.policysystem.entities.CustomerEntity;
import com.policysystem.repositories.CustomerRepository;

public class CreateCustomer {

	public static void main(String[] args) {
		
		//UseCase 1
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml"); 
		CustomerRepository cr = (CustomerRepository) ctx.getBean("customerRepository");
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
		
		cr.addCustomer(c1);
		
	}

}
