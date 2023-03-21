package layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import layer2.InsuranceType;


public class InsuranceTypeDAOImpl implements InsuranceTypeDAO {

	Connection conn;

	public InsuranceTypeDAOImpl() {
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
	public InsuranceType selectInsuranceType(int insuranceTypeId) {
		// TODO Auto-generated method stub
		InsuranceType insuranceType = null; //make a blank currency object

		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM InsuranceType where insuranceTypeId="+insuranceTypeId); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			if (result.next()) {
				insuranceType = new InsuranceType();
				insuranceType .setInsuranceTypeId(result.getInt(1)); //fill it up column wise
				insuranceType.setInsuranceName(result.getString(2));
				insuranceType.setInsuranceDescription(result.getString(3));
				insuranceType.setInsuranceCost(result.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceType;
	}

	@Override
	public List<InsuranceType> selectAllInsuranceType() {
		List<InsuranceType> insuranceTypeList = new ArrayList<InsuranceType>();//blank list
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM InsuranceType"); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {
				InsuranceType insuranceType = new InsuranceType(); //make a blank currency object
				insuranceType.setInsuranceTypeId(result.getInt(1)); //fill it up column wise
				insuranceType.setInsuranceName(result.getString(2));
				insuranceType.setInsuranceDescription(result.getString(3));
				insuranceType.setInsuranceCost(result.getDouble(4));
				insuranceTypeList.add(insuranceType); //push this object in the list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insuranceTypeList;
	}

	@Override
	public void insertInsuranceType(InsuranceType insurancetype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInsuranceType(InsuranceType insurancetype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInsuranceType(int insuranceTypeId) {
		// TODO Auto-generated method stub
		
	}
}