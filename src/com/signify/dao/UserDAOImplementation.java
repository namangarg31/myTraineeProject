package com.signify.dao;

/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.signify.exception.*;
import com.signify.utils.DBUtils;
/**
 * @author Naman
 *
 */
public class UserDAOImplementation implements UserDAOInterface {
		 
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	public boolean validate(int userID,String password,String Role) throws UserNotFoundException
	{
		
           boolean res = false;
		   try{
			   
			      int role = 0;
			      if(Role.equals("admin"))
			      {
			    	  role = 1;
			      }
			      else if(Role.equals("student"))
			      {
	                  role = 2;  		    	  
			      }
			      else if(Role.equals("professor"))
			      {
			    	  role = 3;
			      }
			      System.out.println("Connecting to database...");
			      String sql="select * from src.user where id="+userID+" and password='"+password+"' and roleid="+role;
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
  
			      //STEP 5: Extract data from result set
			      if(rs.next()) {
			    	  if(rs.getInt("id")==userID && rs.getString("password").equals(password) && rs.getInt("roleid")==role) {
			    		  if(Role.equals("student")) {
			    			  if(rs.getInt("isapproved")==0) {
			    				  System.out.println("Pending Admin Approval....");
			    				  return false;
			    			  }
			    		  }
			    		  res = true;
			    		  System.out.println("You have successfully logged in as "+Role+".....");
			    	  }
			
			      }
			      if(!res)
			      {
			    	  throw new UserNotFoundException();
			      }
			      //STEP 6: Clean-up environment
			     
			      stmt.close();
//			      conn.close();
			   }catch(SQLException se){
			      se.printStackTrace();
			   }
			   System.out.println();
			   return res;
	}
	public void updateDAOPassword(int id,String oldpass,String newpass) throws UserNotFoundException
	{
		try{
			   
			     	 
			      String sql="select * from user where id="+id+" and password='"+oldpass+"'";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			
			      boolean res = false;
			      if(rs.next()) {
			    	  if(rs.getInt("id")==id && rs.getString("password").equals(oldpass)) 
			    	  {
			    		  String sql3 = "UPDATE src.user SET password='"+newpass+"' WHERE id="+id;
					      stmt = conn.prepareStatement(sql3);
					      stmt.executeUpdate(sql3);
			    		  res = true;
			    	   }
			      }
			
			      if(!res)
			      {
			    	  throw new UserNotFoundException();
			      }

			   }catch(SQLException se){
			      se.printStackTrace();
			   }
	}
}
