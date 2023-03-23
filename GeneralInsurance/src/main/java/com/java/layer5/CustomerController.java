package com.java.layer5;

import java.sql.Date;
import java.util.ArrayList;
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
import com.java.layer4.CustomerService;
import com.java.layer4.CustomerServiceImpl;


@Path("/customer")
public class CustomerController {

	CustomerService customerService = new CustomerServiceImpl();
	List<Customer> custList = customerService.viewAllCustomerService();
	
	public CustomerController() { System.out.println("Customer Service called...");}
	
	
	// http://ip:port/RestAPI/customer/delete/3
//	@DELETE @Path("/delete/{cid}")
//	public String deleteIt(@PathParam("cid") int x) {
//		boolean found=false;Currency curr=null;
//		for (Currency currency : currList) {
//			if(currency.getCurrencyId() == x) {
//				curr= currency;currList.remove(curr);found=true;break;
//			}
//		}
//		if(found==true) return "Currency deleted";
//		else return "Currency Not Found :"+x;
//	}
	
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
				custList.remove(customer);
				break;
			}
		}
		if(found==true)  { 
			custList.add(custObj);
			return "Customer modified";
		}
		else { 
			return "Customer not found";
		}
	}
	
					       //PROJECT/web.xml/class/method
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
	
	
	
	@GET
	@Path("/viewAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> convertAll() {	
		List<Customer> cList = customerService.viewAllCustomerService();
		return cList;
	}
	
}
