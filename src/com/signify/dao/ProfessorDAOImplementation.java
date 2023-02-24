/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.utils.DBUtils;

/**
 * @author Naman
 *
 */
public class ProfessorDAOImplementation implements ProfessorDAOInterface{

//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	static final String DB_URL = "jdbc:mysql://localhost/src";
//	static final String USER = "root";
//	static final String PASS = "shinamangarg2001";
	Connection conn = DBUtils.getConnection();
	PreparedStatement stmt = null;
	PreparedStatement stmt2 = null;
	public void viewDAOEnrolledStudents(int id)
	{
		 try
		 {
			 System.out.println("Connecting to database...");
//		     conn = DriverManager.getConnection(DB_URL,USER,PASS);
		     String sql = "Select courseid from courses where Professorid="+id+"";
		     stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery(sql);
		     if(!rs.next()) {
		    	  System.out.println("No courses assigned to you yet!");
		     }
		     else
		     {
		    	 int course_id = rs.getInt("courseid");
			     System.out.println("Course ID is:"+course_id);
			     sql = "SELECT s.studentid,s.studentname,s.studentbranch,s.studentbatch FROM registeredcourse as r,student as s WHERE r.studentid = s.studentid AND r.courseCode="+course_id+"";
			     stmt = conn.prepareStatement(sql);
			     rs = stmt.executeQuery(sql);
			     System.out.printf("---------------------------------------------------------------------------------------------%n");
			     System.out.printf("                                      ENROLLED STUDENTS                                      %n");
			     System.out.printf("---------------------------------------------------------------------------------------------%n");
			     System.out.printf("| %-20s | %-20s | %20s | %20s |", "STUDENTID", "STUDENTNAME", "STUDENTBRANCH","STUDENTBATCH");
			     System.out.println();
			     while(rs.next())
		    	 {
		    		  int courseid = rs.getInt("studentid");
		    		  String studentname = rs.getString("studentname");
		    		  String studentbranch = rs.getString("studentbranch");
		    		  int studentbatch = rs.getInt("studentbatch");
		    		  System.out.printf("| %-20s | %-20s | %20s | %20d |%n",courseid,studentname,studentbranch,studentbatch);
		    		  
		    	 }
			     System.out.printf("---------------------------------------------------------------------------------------------%n");
		     }
		     stmt.close();
//		     conn.close();
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
		   }
	}
	
	public void displayDAOStudents(int proff_id)
	{
		try
		{
			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
		    String sql = "SELECT courseid,coursename FROM courses where Professorid="+proff_id;
		    stmt = conn.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery(sql);
		    int cid = -1;
		    String cname = "";
		    if(rs.next())
		    {
		    	cid = rs.getInt("courseid");
		    	cname = rs.getString("coursename");
		    	cname = cname.toUpperCase();
		    }
		    if(cid==-1)
		    {
		    	System.out.println("Currently you are not teaching any course...");
		    }
		    else
		    {
		    	sql = "SELECT studentid from registeredcourse where coursecode="+cid;
		    	stmt = conn.prepareStatement(sql);
		    	rs = stmt.executeQuery(sql);
		    	boolean flag = true;
		    	System.out.printf("---------------------------------------------------------------------------------------------%n");
			    System.out.printf("                           STUDENTS ENROLLED FOR "+cname+"                                   %n");
			    System.out.printf("---------------------------------------------------------------------------------------------%n");
			    System.out.printf("| %-20s | %-20s | %20s | %20s |", "STUDENTID", "STUDENTNAME", "STUDENTBRANCH","STUDENTBATCH");
			    System.out.println();
		    	while(rs.next())
		    	{
		    		flag = false;
		    		int sid = rs.getInt("studentid");
		    		String sql2 = "SELECT studentname, studentbranch, studentbatch from student where studentid="+sid;
		    		stmt2 = conn.prepareStatement(sql2);
  			        ResultSet rs2 = stmt2.executeQuery(sql2);
  			        if(rs2.next())
  			        {
  			        	String name = rs2.getString("studentname");
  			        	String branch = rs2.getString("studentbranch");
  			        	int batch = rs2.getInt("studentbatch");
  			        	System.out.printf("| %-20d | %-20s | %20s | %20d |%n",sid,name,branch,batch);	
  			        }
		    	}
		    	if(flag)
		    	{
		    		System.out.println("You are not teaching this student , grade can't be assigned.....");
		    	}
		    	System.out.printf("---------------------------------------------------------------------------------------------%n");
		   }
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
		 }
		
	}
	
	public void addDAOgrades(int proff_id,int student_id,String grade)
	{
		try
		{
			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
		    String sql = "SELECT courseid FROM courses	where Professorid="+proff_id;
		    stmt = conn.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery(sql);
		    int cid = -1;
		    if(rs.next())
		    {
		    	cid = rs.getInt("courseid");
		    }
		    if(cid==-1)
		    {
		    	System.out.println("Currently you are not teaching any course...");
		    }
		    else
		    {
		    	sql = "SELECT studentid,feepaid FROM registeredcourse where coursecode="+cid;
		    	stmt = conn.prepareStatement(sql);
		    	rs = stmt.executeQuery(sql);
		    	boolean flag = true;
		    	while(rs.next())
		    	{
		    		int sid = rs.getInt("studentid");
		    		int fee = rs.getInt("feepaid");
		    		if(sid==student_id)
		    		{
		    			flag = false;
                        if(fee==1)
                        {
                        	String sql2 = "select * from grade where studid="+student_id+" and courseid="+cid;
                        	stmt = conn.prepareStatement(sql2);
                        	ResultSet rs1 = stmt.executeQuery();
                        	rs1.next();
                        	String grade1 = rs1.getString("grade");
                        	if(grade1!=null) {
                        		System.out.println("Grade Already Added!!");
                        		return;
                        	}
          			        sql = "UPDATE grade set grade='"+grade+"' where studid="+student_id+" and courseid="+cid;
          			        stmt = conn.prepareStatement(sql);
          			        stmt.executeUpdate(sql);
          			        System.out.println("Grade Successfully added......"); 	
                        }
                        else
                        {
                        	System.out.println("Fee for the student is pending you can't assign grade.....");
                        }
		    		}
		    	}
		    	if(flag)
		    	{
		    		System.out.println("You are not teaching this student , grade can't be assigned.....");
		    	}
		    }
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
		      
		 }
   }
}
