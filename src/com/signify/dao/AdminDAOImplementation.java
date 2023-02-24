package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Professor;
import com.signify.utils.DBUtils;

public class AdminDAOImplementation implements AdminDAOInterface{
 
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://localhost/src";
//
//	   //  Database credentials
//	 static final String USER = "root";
//	 static final String PASS = "shinamangarg2001";
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	 PreparedStatement stmt3 = null;
	public void viewDAOInfo(int id)
	 {
		 try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   //Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			   
			 
			   // Let us update age of the record with ID = 102;
			      //int rows = stmt.executeUpdate();
			      //System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      String sql = "SELECT * FROM user where id="+id;
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      System.out.println("USER INFO");
			      System.out.println("------------");
			      while(rs.next()){
			         //Retrieve by column name
			         int userid  = rs.getInt("id");
			         String name = rs.getString("name");
			         int roleid = rs.getInt("roleid");
			         //Display values
			         System.out.println("USER ID : " + userid);
			         System.out.println("NAME : " + name);
			         System.out.println("ROLE ID : " + roleid);
			         System.out.println();
			         
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
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
	public void editDAOInfo(int id,int parameter)  // 1.name   2.password  3.role
	{
		return;
	}
	public void addDAOProfessor(Professor prof)
	{
		
	}
	public void viewDAOStudent() {
		try{
			   
			   
			      System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			   
			 

			      // Let us select all the records and display them.
			      String sql = "SELECT * FROM student where isapproved=0";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      System.out.println("STUDENT LEFT FOR APPROVAL");
			      System.out.println("-------------------------");
			      while(rs.next()){
			         //Retrieve by column name
			         int studentid  = rs.getInt("studentid");
			         String studentbranch = rs.getString("studentbranch");
			         String studentname = rs.getString("studentname");
			         String studentbatch = rs.getString("studentbatch");
			         //Display values
			         System.out.println("STUDENT ID : " + studentid);
			         System.out.println("NAME : " + studentname);
			         System.out.println("BRANCH : " + studentbranch);
			         System.out.println("BATCH :" + studentbatch);
			         System.out.println();
			         
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
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
	
	}
	public boolean viewDAOUnapprove()
	{
		boolean flag = true;
		try{
			   
			   
		      System.out.println("Connecting to database...");
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		   
		 

		      // Let us select all the records and display them.
		      String sql = "SELECT * FROM student where isapproved=0";
		      stmt = conn.prepareStatement(sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      
		    
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("                                  STUDENTS LEFT FOR APPROVAL                                 %n");
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("| %-20s | %-20s | %20s | %20s |", "STUDENTID", "STUDENTBRANCH", "STUDENTNAME","STUDENTBATCH");
		      System.out.println();
		      while(rs.next())
	    	  {
	    		  flag = false;
	    		  int studentid  = rs.getInt("studentid");
			      String studentbranch = rs.getString("studentbranch");
			      String studentname = rs.getString("studentname");
			      int studentbatch = rs.getInt("studentbatch");
	    		  System.out.printf("| %-20d | %-20s | %20s | %20d |%n",studentid,studentbranch,studentname,studentbatch);
	    		  
	    	  }
		      if(flag) {
		      System.out.printf("---------------------------------------------------------------------------------------------%n");	  
		      System.out.println("                                      APPROVAL IS CLEAR                                       ");
		      }
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      
		      
		      
		    
		      //STEP 6: Clean-up environment
		     // rs.close();
		      stmt.close();
//		      conn.close();
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
		   return flag;
	}
	public void approveDAOStudent(int id) {
		try{
			   
			if(id==0)
			{
				System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      String q = "select * from student where isapproved="+0;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  System.out.println("No record found!");
			    	  return;
			      }
			 

			      // Let us select all the records and display them.
			      String sql = "update student set isapproved=1 where isapproved="+0;
			      String sql2 = "update user set isapproved=1 where isapproved="+0;
			      stmt = conn.prepareStatement(sql);
			      stmt.executeUpdate(sql);
			      stmt = conn.prepareStatement(sql2);
			      stmt.executeUpdate(sql2);
			      
			      stmt.close();
//			      conn.close();
			      System.out.println("All students are approved successfully....");
			}
			else
			{
				System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      String q = "select * from student where studentid="+id;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  System.out.println("No record found!");
			    	  return;
			      }
			 

			      // Let us select all the records and display them.
			      String sql = "update student set isapproved=1 where studentid="+id;
			      String sql2 = "update user set isapproved=1 where id="+id;
			      stmt = conn.prepareStatement(sql);
			      stmt.executeUpdate(sql);
			      stmt = conn.prepareStatement(sql2);
			      stmt.executeUpdate(sql2);
                  System.out.println("Student is approved successfully....");
			      
			      stmt.close();
//			      conn.close();
			}
			
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
	}
	public void addDAOCourse(String coursename,int profid)
	{
		try{
			   
				  System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      String q = "select id from user where id="+profid;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  System.out.println("No such professorId exist...");
			      }
			 

			      // Let us select all the records and display them.
			      else
			      {  
			    	  int idProf = rs.getInt("id");
			    	  String sql = "insert into courses(coursename,studentcount,isoffered,Professorid) values(?,?,?,?)";
			    	  stmt = conn.prepareStatement(sql);
				      stmt.setString(1,coursename);
				      stmt.setInt(2,0);
				      stmt.setInt(3,0);
				      stmt.setInt(4,idProf);
				      stmt.executeUpdate();
				      stmt.close();
				      System.out.println("Course added successfully....");
			      }
			      stmt.close();
//			      conn.close();
			      
	       }
		catch(SQLException se){
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
  }
	
	public void removeDAOCourse(String coursename)
	{
		try{
			   
				  System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      String q = "select coursename from courses where coursename='"+coursename+"'";
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  System.out.println("No such course exist...");
			      }
			 

			      // Let us select all the records and display them.
			      else
			      {  
			    	  String sql = "DELETE FROM courses WHERE coursename='"+coursename+"'";
			    	  stmt = conn.prepareStatement(sql);
				      stmt.executeUpdate();
				      System.out.println("Course removed successfully....");
			      }
			      stmt.close();
//			      conn.close();
			      
	       }
		catch(SQLException se){
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
  }
	public void viewDAOCourses()
	{
		System.out.println("Connecting to database...");
		try{
			   
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		      String q = "select * from courses";
		      stmt = conn.prepareStatement(q);
		      ResultSet rs = stmt.executeQuery(q);
		      boolean flag = true;
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("                                        COURSE CATALOG                                      %n");
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("| %-20s | %-20s | %20s | %20s |", "COURSEID", "COURSENAME", "STUDENTCOUNT","PROFESSORID");
		      System.out.println();
		      while(rs.next())
	    	  {
	    		  flag = false;
	    		  int courseid = rs.getInt("courseid");
	    		  String coursename = rs.getString("coursename");
	    		  int studentcount = rs.getInt("studentcount");
	    		  int professorid = rs.getInt("Professorid");
	    		  System.out.printf("| %-20s | %-20s | %20d | %20d |%n",courseid,coursename,studentcount,professorid);
	    		  
	    	  }
		      if(flag) {
		    	  System.out.println("No such course exist...");
		      }
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      stmt.close();
//		      conn.close();
		      
     }
	catch(SQLException se){
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
	}
	public void addDAOAdmin(String name,String password)
	{
		try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   //Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      
			      String sql="insert into user(name,password,roleid) values(?,?,?)";
			      
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,1);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //Fetch user id 
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"' and roleid="+1;
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);
			      int adid = 0;

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve id
			    	 adid = rs.getInt("id");
			         
			      }
			      
			      String sql3="insert into admin values(?,?,?)";			      
			      stmt3 = conn.prepareStatement(sql3);
			      stmt3.setInt(1,adid);
			      stmt3.setString(2,name);
			      stmt3.setString(3,password);
			      stmt3.executeUpdate();
			      //STEP 6: Clean-up environment
			     // rs.close();
		
//			      conn.close();
			      System.out.println("Admin is added successfully.....");
			      System.out.println("Your user id is : "+adid);
			      System.out.println("");
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
			   System.out.println("");
        //end main
	}
	public void addDAOProfessor(String name,String password,String depart,String des)
	{
		try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   //Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      
			      String sql="insert into user(name,password,roleid) values(?,?,?)";
			      
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,3);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //Fetch user id 
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"' and roleid="+3;
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);
			      int profid = 0;

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve id
			    	 profid = rs.getInt("id");
			         
			      }
			      
			      String sql3="insert into professor values(?,?,?,?)";			      
			      stmt3 = conn.prepareStatement(sql3);
			      stmt3.setInt(1,profid);
			      stmt3.setString(2,name);
			      stmt3.setString(3,depart);
			      stmt3.setString(4,des);
			      stmt3.executeUpdate();
			      //STEP 6: Clean-up environment
			     // rs.close();
		
//			      conn.close();
			      System.out.println("Professor is added successfully.....");
			      System.out.println("Your user id is : "+profid);
			      System.out.println("");
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
			   System.out.println("");
     //end main
	}
	public void generateDAOReport(int studid)
	{
		System.out.println("Connecting to database...");
		try{
			   
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		      String q = "select * from grade";
		      stmt = conn.prepareStatement(q);
		      ResultSet rs = stmt.executeQuery(q);
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("                                        GRADE CARD                                      %n");
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      System.out.printf("| %-20s | %-20s | %20s | %20s |", "COURSEID", "COURSENAME", "STUDENTID","GRADE");
		      System.out.println();
		      while(rs.next())
	    	  {
	    		  int courseid = rs.getInt("courseid");
	    		  String sql = "select * from courses where courseid="+courseid;
	    		  String grade = rs.getString("grade");
	    		  stmt2 = conn.prepareStatement(sql);
	    		  ResultSet rs1 = stmt2.executeQuery(sql);
	    		  rs1.next();
	    		  String coursename = rs1.getString("coursename");
	    		  
	    		  System.out.printf("| %-20d | %-20s | %20d | %20s |%n",courseid,coursename,studid,grade);
	    		  
	    	  }
		      System.out.printf("---------------------------------------------------------------------------------------------%n");
		      stmt.close();
//		      conn.close();
		      
     }
	catch(SQLException se){
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
	}
}
