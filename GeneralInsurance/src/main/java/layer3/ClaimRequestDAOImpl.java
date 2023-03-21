package layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import layer2.ClaimRequest;


public class ClaimRequestDAOImpl implements ClaimRequestDAO {
	

	Connection conn;

	public ClaimRequestDAOImpl() {
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
	public List<ClaimRequest> getClaimRequests() {
		// TODO Auto-generated method stub
		List<ClaimRequest> claimList = new ArrayList<ClaimRequest>();
		  try {
			      System.out.println("\nCreating  Statemnt :");
			      Statement statement1 = conn.createStatement();
			      
			      System.out.println("Getting Result");
			      ResultSet result =statement1.executeQuery("select *from ClaimRequest");
			     
			      
			      while(result.next()) {//processing the result
			    	  ClaimRequest e= new ClaimRequest();
			        	 e. setTokenId(result.getInt(1));
			        	 e.setPolicyId(result.getInt(2));
			        	 e.setFid(result.getInt(3));
			        	 e.setBillId(result.getInt(4));
			        	 e.setCause(result.getString(5));
			        	 e.setStatus_(result.getString(6));
			        	 e.setCustomerId(result.getInt(7));
			        	 e.setAmountClaimed(result.getDouble(8));
			        	 claimList.add(e); 
			         }
			      return claimList;
		  }
		  catch(SQLException e) {
				e.printStackTrace();
		  }
			  
		return null;
		
	}


	@Override
	public ClaimRequest getClaimRequest(int customerId) {
		 ClaimRequest e=new ClaimRequest();
		 try {
		      System.out.println("\nCreating  Statemnt :");
		      Statement statement1 = conn.createStatement();
		      
		      System.out.println("Getting Result");
		      ResultSet result =statement1.executeQuery("select *from ClaimRequest where customerId="+customerId);
		     
		      
		      if(result.next()) {//processing the result
		        	 e. setTokenId(result.getInt(1));
		        	 e.setPolicyId(result.getInt(2));
		        	 e.setFid(result.getInt(3));
		        	 e.setBillId(result.getInt(4));
		        	 e.setCause(result.getString(5));
		        	 e.setStatus_(result.getString(6));
		        	 e.setCustomerId(result.getInt(7)); 
		        	 e.setAmountClaimed(result.getDouble(8));
		         }
		      return e;
	  }
	  catch(SQLException c) {
			c.printStackTrace();
	  }
		 return null; 
	}


	@Override
	public void createClaimRequest(ClaimRequest c) {
		// TODO Auto-generated method stub
		try {
			  PreparedStatement  s = conn.prepareStatement("insert into ClaimRequest(policyId,firId,billId,cause,customerId) values(?,?,?,?,?)");
			   s.setInt(1, c.getPolicyId());
			   s.setInt(2, c.getFid());
			   s.setInt(3, c.getBillId());
			   s.setString(4, c.getCause());
			   s.setInt(5, c.getCustomerId());
			   int rows=s.executeUpdate();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	@Override
	public void updateClaimRequest(ClaimRequest c) {
		// TODO Auto-generated method stub
		try {
			 PreparedStatement  s = conn.prepareStatement("update ClaimRequest set status_=?, amountClaimed=?,billId=? where tokenid=?");
			 s.setString(1,c.getStatus_());
			 s.setDouble(2,c.getAmountClaimed());
			 s.setInt(3,c.getBillId());
			 s.setInt(4, c.getTokenId());
			 int rows = s.executeUpdate();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	@Override
	public void removeClaimRequest(int tokenId) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement s = conn.prepareStatement("delete from ClaimRequest  where tokenId=?");
			s.setInt(1, tokenId);
			s.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
	
}