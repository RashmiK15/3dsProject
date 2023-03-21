package layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import layer2.ClaimRequest;
import layer2.Fir;

public class FirDAOImpl implements FirDAO {

	 Connection conn;
		public FirDAOImpl() {
			try {
				System.out.println("Drive Manager loading driver");
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				
				System.out.println("Connecting to database");
				this.conn =DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","root123");
				
				
			} 
	catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	
	@Override
	public List<Fir> getFirs() {
		// TODO Auto-generated method stub
		List<Fir> FirList = new ArrayList<Fir>();
		  try {
			      System.out.println("\nCreating  Statemnt :");
			      Statement statement1 = conn.createStatement();
			      
			      System.out.println("Getting Result");
			      ResultSet result =statement1.executeQuery("select *from Fir");
			     
			      
			      while(result.next()) {//processing the result
			    	  Fir e= new Fir();
			        	 e. setFirId(result.getInt(1));
			        	 e.setCaseDescription(result.getString(2));
			        	 e.setFiledDate(result.getDate(3));
			        	
			        	 FirList.add(e); 
			         }
			      return FirList;
		  }
		  catch(SQLException e) {
				e.printStackTrace();
		  }
			  
		return null;
	}

}