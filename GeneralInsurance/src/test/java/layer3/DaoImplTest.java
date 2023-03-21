package layer3;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import layer2.Customer;
import layer2.Vehicle;


public class DaoImplTest {

	
	@Test
	public void testDrivenDevelopment() {
		System.out.println("Testing condition 1");
		Assertions.assertTrue(100>15);
		System.out.println("condition 1 passed");
	}
	
	@Test
	public void testLoadAllCustomers() {
		
		System.out.println("started DAO testing..");
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		Assertions.assertTrue(custDao!=null); //go ahead only if object creation is successful
		
		List<Customer> custList = custDao.getCustomer();
		
		Assertions.assertTrue(custList.size()>0); //go ahead only if customer list is not empty
		
		for(Customer customer : custList) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void testLoadSingleCustomer() {
		
		System.out.println("started DAO testing..");
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		Assertions.assertTrue(custDao!=null); //go ahead only if object creation is successful
		
		Customer cust = custDao.getCustomer(1003);
		
		Assertions.assertTrue(cust!=null); //go ahead only if customer is not empty

		System.out.println(cust);		
	}
	
	@Test
	public void testAddSingleVehicle() {
		
		System.out.println("started DAO testing..Add");
		
		VehicleDAO vehicleDao = new VehicleDAOImpl();
		
		Assertions.assertTrue(vehicleDao!=null); //go ahead only if object creation is successful
		
		Vehicle vehicle = new Vehicle();
		
		Assertions.assertTrue(vehicle!=null); //go ahead only if vehicle is not empty

		vehicle.setRcNumber("MN12PQ9876");
		vehicle.setChasisNumber(123);
		vehicle.setDateOfPurchase(new Date(1989-8-25));
		vehicle.setManufacturer("Honda");
		vehicle.setEngineNumber("98765");
		vehicle.setVehicleModel("Amaze");
		vehicle.setCost(7822345);
		
		System.out.println(vehicle);
		
		vehicleDao.insertVehicle(vehicle);
		System.out.println("Vehicle added");
	}
	
	@Test
	public void testAddSingleCustomer() {
		
		System.out.println("started DAO testing..Add");
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		Assertions.assertTrue(custDao!=null); //go ahead only if object creation is successful
		
		Customer cust = new Customer();
		
		Assertions.assertTrue(cust!=null); //go ahead only if customer is not empty

		//cust.setCustomerId(1005); //since auto-increment
		cust.setCustomerName("Dennis Schulist");
		cust.setDate(new Date(1999-10-15));
		cust.setAddress("Norberto Crossing, Apt. 950, South Christy, 23505-1337");
		cust.setRcNumber("MN12PQ9876");
		cust.setPolicyId(104);
		
		System.out.println(cust);
		
		custDao.addCustomer(cust);
		System.out.println("Customer added");
	}
	
	@Test
	public void testUpdateSingleCustomer()
	{
		System.out.println("started DAO testing...");
		
		CustomerDao custDao = new CustomerDaoImpl();	
		Assertions.assertTrue(custDao!=null);
		
		Customer cust=new Customer();
		Assertions.assertTrue(cust!=null);
	
		cust.setCustomerId(1010);
		cust.setCustomerName("Dennis Schulist");
		cust.setDate(Date.valueOf("1999-8-25"));
		cust.setAddress("Norberto Crossing, Apt. 950, South Christy, 23505-1337");
		cust.setRcNumber("MN12PQ9876");
		cust.setPolicyId(104);
		
		System.out.println(cust);
		custDao.updateCustomer(cust);
		System.out.println("Customer updated....");
	}
	
	@Test
	public void testDeleteSingleCustomer()
	{
		System.out.println("started DAO testing...");
		
		CustomerDao custDao = new CustomerDaoImpl();	
		Assertions.assertTrue(custDao!=null);
		
		custDao.deleteCustomer(1010);
		System.out.println("Customer deleted....");
	}
}
