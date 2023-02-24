package com.signify.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.service.StudentInterface;
import com.signify.utils.DBUtils;




public class StudentDAOImplementation implements StudentDAOInterface{
	
	

//	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	 static final String DB_URL = "jdbc:mysql://localhost/src";
//
//	   //  Database credentials
//	 static final String USER = "root";
//	 static final String PASS = "shinamangarg2001";
	
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	 PreparedStatement stmt3 = null;
	 public void registerDAOStudent(String name,String password,String branch,int batch)
	 {
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   //Class.forName("com.mysql.cj.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      
			//      String sql="insert into user(name,password,roleid) values(?,?,?)";
			      
			      
			      stmt = conn.prepareStatement(SQLConstants.USER_INSERT);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,2);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      //Fetch user id 
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"'";
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);
			      int studid = 0;

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve id
			    	 studid = rs.getInt("id");
			         
			      }
			      
			      String sql3="insert into student values(?,?,?,?,?)";			      
			      stmt3 = conn.prepareStatement(sql3);
			      stmt3.setInt(1,studid);
			      stmt3.setString(2,name);
			      stmt3.setString(3,branch);
			      stmt3.setInt(4,batch);
			      stmt3.setInt(5,0);
			      stmt3.executeUpdate();
			      //STEP 6: Clean-up environment
			     // rs.close();
		
//			      conn.close();
			      System.out.println("Student is registered successfully.....");
			      System.out.println("Your user id is : "+studid);
			      System.out.println("Pending Approval, Contact Admin");
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
	 public void viewDAOCourses()
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
			      String sql = "SELECT courseid, coursename , studentcount FROM courses";
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      System.out.println("AVAILABLE COURSES");
			      System.out.println("-----------------");
			      while(rs.next()){
			         //Retrieve by column name
			         int userid  = rs.getInt("courseid");
			         String studentname = rs.getString("coursename");
			         int studentcount = rs.getInt("studentcount");
			         //Display values
			         System.out.print("COURSE ID : " + userid);
			         System.out.print(" | COURSE NAME : " + studentname);
			         System.out.print(" | STUDENT COUNT : " + studentcount);
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
			      String sql = "SELECT * FROM student where studentid="+id;
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      System.out.println("STUDENT INFO");
			      System.out.println("------------");
			      while(rs.next()){
			         //Retrieve by column name
			         int userid  = rs.getInt("studentid");
			         String studentname = rs.getString("studentname");
			         String studentbranch = rs.getString("studentbranch");
			         int studentbatch = rs.getInt("studentbatch");
			         int studentid = rs.getInt("studentid");
			         //Display values
			         System.out.println("STUDENT ID : " + userid);
			         System.out.println("STUDENT NAME : " + studentname);
			         System.out.println("STUDENT BRANCH : " + studentbranch);
			         System.out.println("STUDENT BATCH : " + studentbatch);
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
	 public void semDAORegister(int studid,int sem,String doj,int cid,int c2id,int c3id,int c4id,int al1id,int al2id)
	 {
		 System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				  
			
			   
			      String q = "insert into semesterregisteration values(?,?,?)";			  
			      stmt = conn.prepareStatement(q);
			      stmt.setInt(1,studid);
			      stmt.setInt(2, sem);
			      stmt.setString(3, doj);
			      stmt.executeUpdate();
			      System.out.println("Registered to Semester - " + sem);
			      
			      String sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,cid);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,c2id);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,c3id);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,c4id);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,al1id);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      sql = "insert into registeredcourse values(?,?,?,?,?)";
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,al2id);
			      stmt.setInt(2, sem);
			      stmt.setInt(3, studid);
			      stmt.setString(4,"NA");
			      stmt.setInt(5, 0);
			      stmt.executeUpdate();
			      
			      System.out.println("Registration for Course is Successful");
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
		 
	 public void viewDAOCatalog()
	 {
		 System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
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
	 public void addDAOCourse(int studid,int cid)
	 {
		 System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      
			      
			      String qq = "select studentcount from courses where courseid="+cid;
			      stmt = conn.prepareStatement(qq);
			      ResultSet rr = stmt.executeQuery(qq);
			      if(rr.next()) {
			    	  int count = rr.getInt("studentcount");
			    	  if(count>=10) {
			    		  System.out.println("This course is already filled, Please select another course.");
			    		  return;
			    	  }
			      }
			      
			      String query = "select * from registeredcourse where studentid="+studid;
			      int size = 0;
			      stmt = conn.prepareStatement(query);
			      ResultSet res = stmt.executeQuery(query);
			      while(res.next()) {
			    	  size++;
			    	  if(size>=6) {
			    		  System.out.println("Already Registered in "+size+" courses, not allowed to add more.");
			    		  return;
			    	  }
			    	  if(res.getInt("coursecode")==cid) {
			    		  System.out.println("Already Registered in Course - "+cid);
			    		  return;
			    	  }
			      }
			   
			      String q = "select * from semesterregisteration where studentid="+studid;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      int sem;
			      if(rs.next()) {
			    	  sem = rs.getInt("semester");
			    	  String sql = "insert into registeredcourse values(?,?,?,?,?)";
				      stmt = conn.prepareStatement(sql);
				      stmt.setInt(1,cid);
				      stmt.setInt(2, sem);
				      stmt.setInt(3, studid);
				      stmt.setString(4,"NA");
				      stmt.setInt(5,0);
				      stmt.executeUpdate();
				      System.out.println("Course Added Successfully\nPlease Pay Fee To Access Course");
				      
				      String query1 = "update courses set studentcount = studentcount+1 where courseid="+cid;
				      stmt = conn.prepareStatement(query1);
				      stmt.executeUpdate(query1);
			      }
			      else {
			    	  System.out.println("FIRSTLY YOU NEED TO DO SEMESTER REGISTERATION!!!");
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
	 public void myDAOCatalog(int studid)
	 {
		 System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      
			      		      
			      String q = "select * from registeredcourse where studentid="+studid;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      boolean flag = true;
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      System.out.printf("                                    MY COURSE CATALOG                                       %n");
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      System.out.printf("| %-20s | %-20s | %-20s | %-20s |", "COURSECODE", "COURSENAME", "SEMESTER","FEE STATUS");
			      System.out.println();
			      while(rs.next())
		    	  {
		    		  flag = false;
		    		  int courseid = rs.getInt("coursecode");
		    		  String sem = rs.getString("semester");
		    		  int status = rs.getInt("feepaid");
		    		  String q1 = "select * from courses where courseid="+courseid;
				      stmt2 = conn.prepareStatement(q1);
				      ResultSet rs1 = stmt2.executeQuery(q1);
				      String coursename = "";
				      if(rs1.next()) {
				    	  coursename = rs1.getString("coursename");
				      }
		    		  System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",courseid,coursename,sem,status);
		    		  
		    	  }
			      if(flag) {
			    	  System.out.println("No such course exist...");
			      }
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
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
	 public void dropDAOCourse(int studid,int cid)
	 {
		 System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      
			      
			   
			      String q = "delete from registeredcourse where studentid="+studid+" and coursecode="+cid;
			      stmt = conn.prepareStatement(q);
			      stmt.executeUpdate(q);
			      System.out.println("Dropped Course - "+cid);
			      
			      String query = "update courses set studentcount = studentcount-1 where courseid="+cid;
			      stmt = conn.prepareStatement(query);
			      stmt.executeUpdate(query);
			      
			      
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
	 public boolean isDAOPaid(int studid, int semester) {
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      String sql = "select * from registeredcourse where studentid="+studid+" and semester="+semester;
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      boolean flag = true;
			      while(rs.next()) {
			    	  flag = false;
			    	  int feepaid = rs.getInt("feepaid");
			    	  if(feepaid==0) {
			    		  return false;
			    	  }
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
			
			return true;
		}
	 
	 public void feeDAOCatalog(int studid,int sem,int total_fees[]) {
//			System.out.println("View Fee DAO catalog");
			// TODO Auto-generated method stub
			System.out.println("Connecting to database...");
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      
			      int totalFee = 0;
			      
			      String q = "select * from registeredcourse where studentid="+studid + " and semester="+sem + " and feepaid=0";
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      boolean flag = true;
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      System.out.printf("                                    MY COURSE CATALOG                                       %n");
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      System.out.printf("| %-20s | %-20s | %-20s | %-20s |", "COURSECODE", "COURSENAME", "SEMESTER","FEE AMOUNT");
			      System.out.println();
			      while(rs.next())
		    	  {
		    		  flag = false;
		    		  int courseid = rs.getInt("coursecode");
		    		  String q1 = "select * from courses where courseid="+courseid;
				      stmt2 = conn.prepareStatement(q1);
				      ResultSet rs1 = stmt2.executeQuery(q1);
				      String coursename = "";
				      int fees = 0;
				      if(rs1.next()) {
				    	  coursename = rs1.getString("coursename");
				    	  fees = rs1.getInt("coursefee");
				    	  totalFee+=fees;
				      }
		    		  System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",courseid,coursename,sem,fees);
		    		  
		    	  }
			      if(flag) {
			    	  System.out.println("No such course exist...");
			      }
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      
			      System.out.printf("| %-66s | %-20s |%n","Fees to be Paid:",totalFee);
			      System.out.printf("--------------------------------------------------------------------------------------------%n");
			      
			      stmt.close();
//			      conn.close();
			      total_fees[0] = totalFee;
			      
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
	 public void payDAOFee(int studid, int sem, int mode, int amt) {
			try{
				   
//			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      
			      String modePay = mode==1?"online":"offline";
			      boolean flag = false;
			      String sql = "update registeredcourse set feepaid=1 where studentid="+studid+" and semester="+sem;
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.executeUpdate();
			      String sql1 = "insert into payment(studentid,semester,modeofpayment,amount) values(?,?,?,?)";
			      stmt = conn.prepareStatement(sql1);
			      stmt.setInt(1, studid);
			      stmt.setInt(2, sem);
			      stmt.setString(3, modePay);
			      stmt.setInt(4, amt);
			      stmt.executeUpdate();
			      String sql2 = "SELECT courseCode,studentid from registeredcourse where feepaid=1";
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);
			      while(rs.next()) {
			    	  flag = true;
			    	  String sql3 = "INSERT INTO grade(studid,courseid) values(?,?)";
			    	  stmt3 = conn.prepareStatement(sql3);
			    	  stmt3.setInt(1, rs.getInt("studentid"));
			    	  stmt3.setInt(2, rs.getInt("courseCode"));
			    	  stmt3.executeUpdate();
			      }
			      if(flag==false) {
			    	  System.out.println("No student have paid the fees yet");
			      }
			        
			      		   
			      System.out.println("Fee Paid Succesfully! Have a Nice Day!"); 
			      
			      stmt.close();
			      stmt3.close();
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
public void payDAOFeeOnline(int studid,int sem,int pay_choice,int amt,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry)
{
	try{
		   
//	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      
	      String modePay = "online";
	      boolean flag = false;
	      String sql = "update registeredcourse set feepaid=1 where studentid="+studid+" and semester="+sem;
	      
	      cardType = cardType.toUpperCase();
	      bankName = bankName.toUpperCase();
	      cardName = cardName.toUpperCase();
	      stmt = conn.prepareStatement(sql);
	      stmt.executeUpdate();
	      String sql1 = "insert into payment(studentid,semester,modeofpayment,amount) values(?,?,?,?)";
	      stmt = conn.prepareStatement(sql1);
	      stmt.setInt(1, studid);
	      stmt.setInt(2, sem);
	      stmt.setString(3, modePay);
	      stmt.setInt(4, amt);
	      stmt.executeUpdate();
	      String sql2 = "SELECT coursecode,studentid from registeredcourse where feepaid=1";
	      stmt2 = conn.prepareStatement(sql2);
	      ResultSet rs = stmt2.executeQuery(sql2);
	      while(rs.next()) {
	    	  flag = true;
	    	  int courseCode = rs.getInt("coursecode");
	    	  String sql4 = "select * from grade where studid="+studid+" and courseid="+courseCode;
	    	  stmt2 = conn.prepareStatement(sql4);
	    	  ResultSet rrss = stmt2.executeQuery();
	    	  if(rrss.next()) {
	    		  continue;
	    	  }
	    	  String sql3 = "INSERT INTO grade(studid,courseid) values(?,?)";
	    	  stmt3 = conn.prepareStatement(sql3);
	    	  stmt3.setInt(1, studid);
	    	  stmt3.setInt(2, courseCode);
	    	  stmt3.executeUpdate();
	    	  
	      }
	      sql1 = "SELECT paymentid FROM payment where studentid="+studid+" AND semester="+sem;
	      stmt = conn.prepareStatement(sql1);
	      rs = stmt.executeQuery(sql1);
	      if(rs.next())
	      {
	    	  int payid = rs.getInt("paymentid");
	    	  sql2 = "INSERT INTO onlinepayment values(?,?,?,?,?,?,?)";
	    	  stmt2 = conn.prepareStatement(sql2);
	    	  stmt2.setString(1,cardType);
	    	  stmt2.setString(2,bankName);
	    	  stmt2.setInt(3,cardNumber);
	    	  stmt2.setString(4,cardName);
	    	  stmt2.setInt(5,cvv);
	    	  stmt2.setString(6,expiry);
	    	  stmt2.setInt(7,payid);
	    	  stmt2.executeUpdate();
	      }
	      
	      System.out.println("Fee Paid Succesfully! Find your fee receipt below");
	      System.out.println();
	      System.out.println("-----------------------------------------------");
	      System.out.println("|                   FEE RECEIPT               |");
	      System.out.println("-----------------------------------------------");
	      System.out.printf("| %-30s | %-10s |%n","NAME",cardName);
	      System.out.println("-----------------------------------------------");
	      System.out.printf("| %-30s | %-10s |%n","CARD TYPE",cardType);
	      System.out.println("-----------------------------------------------");
	      System.out.printf("| %-30s | %-10s |%n","BANK NAME",bankName);
	      System.out.println("-----------------------------------------------");
	      System.out.printf("| %-30s | %-10s |%n","SEMESTER",sem);
	      System.out.println("-----------------------------------------------");
	      System.out.printf("| %-30s | %-10s |%n","AMOUNT PAID",amt);
	      System.out.println("-----------------------------------------------");
	      System.out.println();
	      stmt.close();
//	      conn.close();
	      
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

