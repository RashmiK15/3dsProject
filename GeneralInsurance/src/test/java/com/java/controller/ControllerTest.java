package com.java.controller;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.java.layer2.Customer;
import com.java.layer5.CustomerController;

public class ControllerTest {
   
	public ControllerTest() {
		// TODO Auto-generated constructor stub
		

	}
	 @Test
    public void test1() {
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

}
