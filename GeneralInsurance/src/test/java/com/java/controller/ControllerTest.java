package com.java.controller;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.java.layer2.Customer;
import com.java.layer5.CustomerController;

public class ControllerTest {
   
	public ControllerTest() {
		System.out.println("Controller Test ctr()..");
	}
	
	@Test
    public void testAdd() {
		CustomerController c= new CustomerController();
		
		Customer c1=new Customer();
		
		c1.setCustomerName("ABCD");
		c1.setDate(Date.valueOf("1999-8-25"));
		c1.setAddress("gbvlainb");
		c1.setDrivingLicence(3556);
		c1.setPolicyId(104);
		c1.setRcNumber("452");
		c.addIt(c1);
    }
	
	@Test
    public void testUpdate() {
		CustomerController c= new CustomerController();
		
		Customer c1=new Customer();
		
		c1.setCustomerId(1012);
		c1.setCustomerName("ABCD");
		c1.setDate(Date.valueOf("1999-8-25"));
		c1.setAddress("gbvlainb");
		c1.setDrivingLicence(3556);
		c1.setPolicyId(104);
		c1.setRcNumber("452");
		c.modifyIt(c1);
    }

	@Test
    public void testDelete() {
		CustomerController c= new CustomerController();
		c.deleteIt(1012);
    }
}
