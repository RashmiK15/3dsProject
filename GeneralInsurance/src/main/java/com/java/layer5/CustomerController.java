package com.java.layer5;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.layer2.Customer;
import com.java.layer4.VehicleAlreadyExistsException;
import com.java.layer4.CustomerNotFoundException;
import com.java.layer4.CustomerService;
import com.java.layer4.CustomerServiceImpl;


@Path("/customer")
public class CustomerController {

	CustomerService customerService = new CustomerServiceImpl();
	List<Customer> custList = customerService.viewAllCustomerService();
	
	public CustomerController() { System.out.println("Customer Service called...");}
	
	
	// http://ip:port/GeneralInsurance/ins/customer/delete/3
	@DELETE @Path("/delete/{cid}")
	public String deleteIt(@PathParam("cid") int x) {
		boolean customerFound=false;
		for (Customer customer : custList) {
			if(customer.getCustomerId() == x) {
				customerFound=true;
				break;
			}
		}
		if(customerFound==true) {
			try {
				customerService.removeCustomerService(x);
			} 
			catch (CustomerNotFoundException e) {
				e.printStackTrace();
			}
			return "Customer record deleted";
		}
			
		else {
			return "Customer Not Found :"+x;
		}
	}
	
	
	
	// http://ip:port/GeneralInsurance/ins/customer/add
	@POST @Path("/add")
	public String addIt(Customer custObj) {
		try {
			customerService.addCustomerService(custObj);
			return "customer added successfully";

		} catch (VehicleAlreadyExistsException e) {
			return e.getMessage();
		}
	}
	
	
	
	// http://ip:port/GeneralInsurance/ins/customer/update
	@PUT @Path("/update")
	public String modifyIt(Customer custObj) {
		boolean found=false;
		Customer cust=null;
		for (Customer customer : custList) {
			if(customer.getCustomerId() == custObj.getCustomerId()) {
				found=true;
				//custList.remove(customer);
				break;
			}
		}
		if(found==true)  { 
			try {
				customerService.modifyCustomerService(custObj);
			} 
			catch (CustomerNotFoundException e) {
				e.printStackTrace();
			}
			return "Customer modified";
		}
		else { 
			return "Customer not found";
		}
	}
	
	

	// http://localhost:port/GeneralInsurance/ins/customer/greet
	@GET
	@Path("/greet") // action mappings
	public String welcome() {
		return "<h1> Welcome to Motor Insurance Services </h1>";
	}
	
	
	
	// http://ip:port/GeneralInsurance/ins/customer/viewCustomer/3
	@GET
	@Path("/viewCustomer/{cid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer viewIt(@PathParam("cid") int x) {
		
		Customer cust=null;
		for (Customer customer : custList) {
			if(customer.getCustomerId() == x) {
				cust = customer;
			}
		}
		return cust;
	}
	
	
	
	// http://ip:port/GeneralInsurance/ins/customer/viewAll
	@GET
	@Path("/viewAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> convertAll() {	
		List<Customer> cList = customerService.viewAllCustomerService();
		return cList;
	}
	
}
