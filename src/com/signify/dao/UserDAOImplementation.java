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
 * @author asus
 *
 */
public class UserDAOImplementation implements UserDAOInterface {
	
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	 static final String DB_URL = "jdbc:mysql://localhost/src";
//
//	   //  Database credentials
//	 static final String USER = "root";
//	 static final String PASS = "shinamangarg2001";
	 
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	public boolean validate(int userID,String password,String Role) throws UserNotFoundException
	{
		
           boolean res = false;
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
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
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			 
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
			      //Handle errors for JDBC
				   System.out.println("SQLException"+ se.getErrorCode()+"-->"+se.getCause());
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
				   System.out.println("Exception"+e.getLocalizedMessage());
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			   }//end try
			   System.out.println();
      //end main
			   return res;
	}
	public void updateDAOPassword(int id,String oldpass,String newpass)
	{
		try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			      System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			 
			      String sql="select * from user where id="+id+" and password='"+oldpass+"'";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      boolean res = false;
			      if(rs.next()) {
			    	  if(rs.getInt("id")==id && rs.getString("password").equals(oldpass)) 
			    	  {
			    		  String sql3 = "UPDATE src.user SET password='"+newpass+"' WHERE id="+id;
					      stmt = conn.prepareStatement(sql3);
					      stmt.executeUpdate(sql3);
			    		  res = true;
			    		  System.out.println("You have successfully changed your password.....");
			    	   }
			      }
			
			      if(!res)
			      {
			    	  System.out.println("Invalid credentials");
			      }
			      //STEP 6: Clean-up environment
			     
			      stmt.close();
//			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
				   System.out.println("SQLException"+ se.getErrorCode()+"-->"+se.getCause());
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
				   System.out.println("Exception"+e.getLocalizedMessage());
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			   }//end try
			   System.out.println();
   //end main
	}
}
