package com.java.layer4;

import java.util.List;

import com.java.layer2.Customer;
import com.java.layer3.CustomerDao;
import com.java.layer3.CustomerDaoImpl;


public class CustomerServiceImpl implements CustomerService{

	CustomerDao custDao = new CustomerDaoImpl();
	
	public CustomerServiceImpl() {
		System.out.println("Customer Service Implementation ctr()..");
	}

	@Override
	public Customer viewCustomerService(int customerId) {
		Customer cust = custDao.getCustomer(customerId);
		return cust;
	}
	
	
	@Override
	public List<Customer> viewAllCustomerService() {
		List<Customer> custList = custDao.getCustomer();
		return custList;
	}

	@Override
	public String addCustomerService(Customer customerToAdd) throws VehicleAlreadyExistsException {
		List<Customer> listCustomers = custDao.getCustomer();
		boolean vehicleFound = false;
		
		for(Customer cust : listCustomers) {
			if(cust.getRcNumber().equals(customerToAdd.getRcNumber())) {
				vehicleFound = true;
				break;
			}
		}
		if(vehicleFound==true)
			throw new VehicleAlreadyExistsException("Car already insured!");
		else {
			custDao.addCustomer(customerToAdd);
			return "Customer added!";
		}
	}

	
	@Override
	public String modifyCustomerService(Customer customerToModify) throws CustomerNotFoundException {
		List<Customer> listCustomers = custDao.getCustomer();
		boolean customerFound = false;
		
		for(Customer cust : listCustomers) {
			if(cust.getCustomerId()==(customerToModify.getCustomerId())) {
				customerFound = true;
				break;
			}
		}
		if(customerFound == false) 
			throw new CustomerNotFoundException("Couldn't find customer details!");
		else {
			custDao.updateCustomer(customerToModify);
			return "Customer modified";
		}
	}


	@Override
	public String removeCustomerService(int customerId) throws CustomerNotFoundException{
		List<Customer> listCustomers = custDao.getCustomer();
		boolean customerFound = false;
		
		for(Customer customer : listCustomers) {
			if(customer.getCustomerId() == customerId) {
				customerFound = true;
				break;
			}
		}
		if(customerFound == true) {
			custDao.deleteCustomer(customerId);
			return "Customer record deleted";
		}
		else {
			throw new CustomerNotFoundException("Coudn't find customer details!");
		}
	}
}
