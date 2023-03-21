package layer3;

import layer2.Vehicle;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import layer2.Vehicle;



public class VehicleDAOImpl implements VehicleDAO {

	Connection conn;

	public VehicleDAOImpl() {
			try {
				System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				System.out.println("1. driver...loaded");
				System.out.println("Trying to connect to the DB...");
				this.conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Learn@mysql11");
				System.out.println("2. Connected to the DB :" + conn);
			} catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public Vehicle selectVehicle(String rcNumber) {
		// TODO Auto-generated method stub
		Vehicle vehicle = null; //make a blank currency object

		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM vehicle where rcNumber='"+rcNumber+"'"); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			if (result.next()) {
				vehicle = new Vehicle();
				vehicle.setRcNumber(result.getString(1)); //fill it up column wise
				vehicle.setChasisNumber(result.getInt(2));
				vehicle.setDateOfPurchase(result.getDate(3));
				vehicle.setManufacturer(result.getString(4));
				vehicle.setEngineNumber(result.getString(5));
				vehicle.setVehicleModel(result.getString(6));
				vehicle.setCost(result.getFloat(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> selectAllVehicles() {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();//blank list
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM vehicle"); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setRcNumber(result.getString(1)); //fill it up column wise
				vehicle.setChasisNumber(result.getInt(2));
				vehicle.setDateOfPurchase(result.getDate(3));
				vehicle.setManufacturer(result.getString(4));
				vehicle.setEngineNumber(result.getString(5));
				vehicle.setVehicleModel(result.getString(6));
				vehicle.setCost(result.getFloat(7));
				vehicleList.add(vehicle); //push this object in the list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleList;
	}
	
	@Override
	public void insertVehicle(Vehicle vehicle) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into vehicle(rcNumber, chasisNumber, dateOfPurchase, manufacturer, engineNumber, vehicleModel, cost) values(?,?,?,?,?,?,?)");
			System.out.println("3. PreparedStatement created....");

			
			pst.setString(1, vehicle.getRcNumber());
			pst.setInt(2, vehicle.getChasisNumber());
			pst.setDate(3, vehicle.getDateOfPurchase());
			pst.setString(4, vehicle.getManufacturer());
			pst.setString(5, vehicle.getEngineNumber());
			pst.setString(6, vehicle.getVehicleModel());
			pst.setFloat(7, vehicle.getCost());

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the insert query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void updateVehicle(Vehicle vehicle) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE Vehicle set chasisNumber=?, dateOfPurchase=?, manufacturer=?, engineNumber=?, vehicleModel=?, cost=? WHERE rcNumber=?");
			System.out.println("3. PreparedStatement created....");

			pst.setInt(1, vehicle.getChasisNumber());
			pst.setDate(2, vehicle.getDateOfPurchase());
			pst.setString(3, vehicle.getManufacturer());
			pst.setString(4, vehicle.getEngineNumber());
			pst.setString(5, vehicle.getVehicleModel());
			pst.setFloat(6, vehicle.getCost());
			pst.setString(7, vehicle.getRcNumber());
			


			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the update query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteVehicle(String rcNumber) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM vehicle  where rcNumber=?");
			System.out.println("3. PreparedStatement created....");

			pst.setString(1, rcNumber);
			
			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the delete query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}