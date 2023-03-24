package com.java.service;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.java.layer2.Customer;
import com.java.layer4.CustomerNotFoundException;
import com.java.layer4.CustomerService;
import com.java.layer4.CustomerServiceImpl;
import com.java.layer4.VehicleAlreadyExistsException;

public class CustomerServiceImplTest {

	
	@Test
	public void addCustomerTest() throws VehicleAlreadyExistsException {
		
		CustomerService custService = new CustomerServiceImpl();
		
		Customer customerToAdd = new Customer();
		customerToAdd.setCustomerName("Leanne Graham");
		customerToAdd.setDate(new Date(1990-02-02));
		customerToAdd.setPolicyId(105);
		customerToAdd.setRcNumber("287");
		customerToAdd.setDrivingLicence(9895);
		customerToAdd.setAddress("Kulas Light, Apt. 556, Gwenborough, 92998-3874");
		
		String res = custService.addCustomerService(customerToAdd);
		System.out.println(res);
		
	}
	
	
	@Test
	public void modifyCustomerTest() throws CustomerNotFoundException{
		
		CustomerService custService = new CustomerServiceImpl();
		Customer customerToModify = new Customer();
		customerToModify.setCustomerId(1012);
		customerToModify.setCustomerName("Leann Graham");
		customerToModify.setDate(Date.valueOf("1990-02-02"));
		customerToModify.setRcNumber("452");
		customerToModify.setPolicyId(104);
		customerToModify.setAddress("Kulas Light, Apt. 556, Gwenborough, 92998-3874");
		
		String res = custService.modifyCustomerService(customerToModify);
		System.out.println(res);
		
	}
	
	@Test
	public void viewAllCustomerTest() {
		
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> custList = custService.viewAllCustomerService();
		
		System.out.println(custList);
	}
}
