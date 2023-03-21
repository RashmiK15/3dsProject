package layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import layer2.InsuranceIssued;

public class InsuranceIssuedDAOImpl implements InsuranceIssuedDAO {

	Connection conn;

	public InsuranceIssuedDAOImpl() {
			try {
				System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				System.out.println("1. driver...loaded");
				System.out.println("Trying to connect to the DB...");
				this.conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root@123");
				System.out.println("2. Connected to the DB :" + conn);
			} catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public InsuranceIssued selectInsuranceIssued(int policyId) {
		// TODO Auto-generated method stub
		InsuranceIssued insuranceIssued = null; //make a blank currency object

		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM InsuranceIssued where policyId="+policyId); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			if (result.next()) {
				insuranceIssued = new InsuranceIssued();
				insuranceIssued.setPolicyId(result.getInt(1)); //fill it up column wise
				insuranceIssued.setStartDate(result.getDate(2));
				insuranceIssued.setExpiryDate(result.getDate(3));
				insuranceIssued.setInsuranceTypeId(result.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceIssued;
	}

	@Override
	public List<InsuranceIssued> selectAllInsuranceIssued() {
		List<InsuranceIssued> insuranceIssuedList = new ArrayList<InsuranceIssued>();//blank list
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM InsuranceIssued"); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {
				InsuranceIssued insuranceIssued = new InsuranceIssued(); //make a blank currency object
				insuranceIssued.setPolicyId(result.getInt(1)); //fill it up column wise
				insuranceIssued.setStartDate(result.getDate(2));
				insuranceIssued.setExpiryDate(result.getDate(3));
				insuranceIssued.setInsuranceTypeId(result.getInt(4));
				insuranceIssuedList.add(insuranceIssued); //push this object in the list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceIssuedList;
	}

	@Override
	public void insertInsuranceIssued(InsuranceIssued insuranceIssued) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into InsuranceIssued (policyId,startDate,expiryDate,insuranceTypeId) values(?,?,?,?)");
			System.out.println("3. PreparedStatement created....");

			
			pst.setInt(1, insuranceIssued.getPolicyId());
			
			pst.setDate(2, insuranceIssued.getStartDate());
			pst.setDate(3, insuranceIssued.getExpiryDate());
			
			pst.setInt(4, insuranceIssued.getInsuranceTypeId());

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the insert query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void updateInsuranceIssued(InsuranceIssued insuranceIssued) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE InsuranceIssued set startDate=?, expiryDate=?, insuranceTypeId=? where policyId=?");
			System.out.println("3. PreparedStatement created....");

			pst.setDate(1, insuranceIssued.getStartDate());
			pst.setDate(2, insuranceIssued.getExpiryDate());
			pst.setInt(3, insuranceIssued.getInsuranceTypeId());
			
			pst.setInt(4, insuranceIssued.getPolicyId());


			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the update query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteInsuranceIssued(int policyId)
	{
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM InsuranceIssued  where policyId=?");
			System.out.println("3. PreparedStatement created....");

			pst.setInt(1, policyId);
			
			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the delete query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

 
}
