package layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import layer2.Customer;

public class CustomerDaoImpl implements CustomerDao{

	Connection conn;
	
	public CustomerDaoImpl() {

		try {
			System.out.println("Loading the driver..");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			System.out.println("Connecting to db..");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root123");
			
			System.out.println("Connected to db: "+conn);
			
		}
		catch(SQLException e) {
			System.out.println("Exception thrown: "+e);
		}
	}

	@Override
	public void addCustomer(Customer c) {
		try {

			PreparedStatement pst = conn.prepareStatement("INSERT INTO CUSTOMER (customerName, dob, address, rcNumber, policyId) VALUES(?,?,?,?,?)");
			System.out.println("3. Statement created....");

			//pst.setInt(1, e.getCurrencyId());
			pst.setString(1, c.getCustomerName());
			pst.setDate(2, c.getDate());
			pst.setString(3, c.getAddress());
			pst.setString(4,  c.getRcNumber());
			pst.setInt(5,  c.getPolicyId());

			int rows = pst.executeUpdate(); // run the insert query

			System.out.println("4. executed the query: " + rows + " row(s) inserted");

		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}

	@Override
	public List<Customer> getCustomer() {
		List<Customer> custList = new ArrayList<Customer>(); // blank list

		try {

			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");

			ResultSet result = statement.executeQuery("SELECT * FROM CUSTOMER");
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {

				Customer customer = new Customer();

				customer.setCustomerId(result.getInt(1));
				customer.setCustomerName(result.getString(2));
				customer.setDate(result.getDate(3));
				customer.setAddress(result.getString(4));
				customer.setRcNumber(result.getString(5));
				customer.setPolicyId(result.getInt(6));
				custList.add(customer); // push this object in the list
			}
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		return custList;
	}

	@Override
	public Customer getCustomer(int cno) {
		Customer customer = new Customer();
		try {

			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");

			ResultSet result = statement.executeQuery("SELECT * FROM CUSTOMER WHERE customerId = "+cno);
			System.out.println("4. execute the query");
			
			System.out.println("5. acquire the result and process it");

			
			if (result.next()) {
				customer.setCustomerId(result.getInt(1));
				customer.setCustomerName(result.getString(2));
				customer.setDate(result.getDate(3));
				customer.setAddress(result.getString(4));
				customer.setRcNumber(result.getString(5));
				customer.setPolicyId(result.getInt(6));
			}
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		return customer;
	}

	@Override
	public void updateCustomer(Customer cno) {
		try {

			PreparedStatement pst = conn.prepareStatement("UPDATE CUSTOMER SET customerName=?, dob=?, address=?, rcNumber=?, policyId=? WHERE customerId=?");
			System.out.println("3. Statement created....");

			pst.setString(1, cno.getCustomerName());
			pst.setDate(2, cno.getDate());
			pst.setString(3, cno.getAddress());
			pst.setString(4, cno.getRcNumber());
			pst.setInt(5, cno.getPolicyId());
			pst.setInt(6,  cno.getCustomerId());

			int rows = pst.executeUpdate(); // run the insert query

			System.out.println("4. executed the query: " + rows + " row(s) updated");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void deleteCustomer(int cno) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM CUSTOMER WHERE customerId="+cno);
			System.out.println("3. Statement created....");


			int rows = pst.executeUpdate(); // run the insert query

			System.out.println("4. executed the query: " + rows + " row(s) deleted");

		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
