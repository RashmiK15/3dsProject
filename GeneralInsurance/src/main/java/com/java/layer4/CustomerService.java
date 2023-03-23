package com.java.layer4;

import java.util.List;

import com.java.layer2.Customer;

public interface CustomerService {

	Customer viewCustomerService(int customerId);
	List<Customer> viewAllCustomerService();
	String addCustomerService(Customer customer) throws VehicleAlreadyExistsException;
	String modifyCustomerService(Customer customer) throws CustomerNotFoundException;
	String removeCustomerService(int customerId);

	// float calculateCurrencyService(String s,String t, float amt) throws
	// CurrencyNotFoundException,SourceCurrencyNotFoundException,
	// TargetCurrencyNotFoundException;

}
