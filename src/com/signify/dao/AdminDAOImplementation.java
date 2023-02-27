package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.GradeCard;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.ProfessorNotFoundException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.utils.DBUtils;

public class AdminDAOImplementation implements AdminDAOInterface{
 
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	 PreparedStatement stmt3 = null;
	
	
	
	public List<Student> viewDAOUnapprove()
	{
		List<Student>students = new ArrayList<Student>();
		try{

		      String sql = "SELECT * FROM student where isapproved=0";
		      stmt = conn.prepareStatement(sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next())
	    	  {
	    		  int studentid  = rs.getInt("studentid");
			      String studentbranch = rs.getString("studentbranch");
			      String studentname = rs.getString("studentname");
			      int studentbatch = rs.getInt("studentbatch");
			      Student obj = new Student();
			      obj.setUserId(studentid);
			      obj.setBranch(studentbranch);
			      obj.setName(studentname);
			      obj.setBatch(studentbatch);
			      students.add(obj);
	    	  }		
		      
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		return students;
	}
	public void approveDAOStudent(int id) throws StudentNotFoundForApprovalException
	{
		try{
			   
			if(id==0)
			{
			      String q = "select * from student where isapproved="+0;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  throw new StudentNotFoundForApprovalException();
			      }
			 

			      // Let us select all the records and display them.
			      String sql = "update student set isapproved=1 where isapproved="+0;
			      String sql2 = "update user set isapproved=1 where isapproved="+0;
			      stmt = conn.prepareStatement(sql);
			      stmt.executeUpdate(sql);
			      stmt = conn.prepareStatement(sql2);
			      stmt.executeUpdate(sql2);
			      
			}
			else
			{

			   
			      String q = "select * from student where studentid="+id;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      
			      //EXXCEPTION TO BE RAISED
			      if(!rs.next()) {
			    	  throw new StudentNotFoundForApprovalException();
			      }
			 

			      // Let us select all the records and display them.
			      String sql = "update student set isapproved=1 where studentid="+id;
			      String sql2 = "update user set isapproved=1 where id="+id;
			      stmt = conn.prepareStatement(sql);
			      stmt.executeUpdate(sql);
			      stmt = conn.prepareStatement(sql2);
			      stmt.executeUpdate(sql2);
			}
			
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
	}
	public void addDAOCourse(String coursename,int profid)throws ProfessorNotFoundException
	{
		try{
			   
				  System.out.println("Connecting to database...");			   
			      String q = "select id from user where id="+profid;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  throw new ProfessorNotFoundException();
			      }
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
				  
			      }
			      
	       }
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
  }
	
	public void removeDAOCourse(String coursename)throws CourseNotFoundException
	{
		try{
			   
				  System.out.println("Connecting to database...");
			      String q = "select coursename from courses where coursename='"+coursename+"'";
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      if(!rs.next()) {
			    	  throw new CourseNotFoundException();
			      }
			 

			      // Let us select all the records and display them.
			      else
			      {  
			    	  String sql = "DELETE FROM courses WHERE coursename='"+coursename+"'";
			    	  stmt = conn.prepareStatement(sql);
				      stmt.executeUpdate();
			      }
			      
	       }
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
  }
	public List<Course> viewDAOCourses()throws CourseNotFoundException
	{
		List<Course>courses = new ArrayList<Course>();
		try{
			   
		      String q = "select * from courses";
		      stmt = conn.prepareStatement(q);
		      ResultSet rs = stmt.executeQuery(q);
		      while(rs.next())
	    	  {
	    		  int courseid = rs.getInt("courseid");
	    		  String coursename = rs.getString("coursename");
	    		  int studentcount = rs.getInt("studentcount");
	    		  int professorid = rs.getInt("Professorid");
	    		  Course obj = new Course();
	    		  obj.setCourseId(courseid);
	    		  obj.setCourseName(coursename);
	    		  obj.setStudentCount(studentcount);
	    		  obj.setProfessorId(professorid);
	    		  courses.add(obj);
	    	  }	      
         }
	   catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }
	   return courses;
	}
	public int addDAOAdmin(String name,String password)
	{
		ResultSet rs = null;
		int aid = 0;
		try{
			      
			      String sql="insert into user(name,password,roleid) values(?,?,?)";
			      
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,1);
			      
			      stmt.executeUpdate();
			      //Fetch user id 
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"' and roleid="+1;
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      rs = stmt2.executeQuery(sql2);
			      while(rs.next()){
				         //Retrieve id
				    	 aid = rs.getInt("id");
				         
				      }
			      
			      String sql3="insert into admin values(?,?,?)";			      
			      stmt3 = conn.prepareStatement(sql3);
			      stmt3.setInt(1,aid);
			      stmt3.setString(2,name);
			      stmt3.setString(3,password);
			      stmt3.executeUpdate();
			      
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
               return aid;
	}
	public int addDAOProfessor(String name,String password,String depart,String des)
	{
		int pid = 0;
		try{
			      
			      String sql="insert into user(name,password,roleid) values(?,?,?)";
			      
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,3);
			      
			      stmt.executeUpdate();
			      //Fetch user id 
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"' and roleid="+3;
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve id
			    	 pid = rs.getInt("id");
			         
			      }
			      
			      String sql3="insert into professor values(?,?,?,?)";			      
			      stmt3 = conn.prepareStatement(sql3);
			      stmt3.setInt(1,pid);
			      stmt3.setString(2,name);
			      stmt3.setString(3,depart);
			      stmt3.setString(4,des);
			      stmt3.executeUpdate();
			      
			      
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
               return pid;
	}
	public List<GradeCard> generateDAOReport(int studid)
	{
		List<GradeCard> gc = new ArrayList<GradeCard>();
		try{
			   
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		      String q = "select * from grade where studid="+studid;
		      stmt = conn.prepareStatement(q);
		      ResultSet rs = stmt.executeQuery(q);
		      while(rs.next())
	    	  {
	    		  int courseid = rs.getInt("courseid");
	    		  String sql = "select * from courses where courseid="+courseid;
	    		  String grade = rs.getString("grade");
	    		  stmt2 = conn.prepareStatement(sql);
	    		  ResultSet rs1 = stmt2.executeQuery(sql);
	    		  rs1.next();
	    		  String coursename = rs1.getString("coursename");
	    		  GradeCard obj = new GradeCard();
	    		  obj.setCourseID(courseid);
	    		  obj.setCourseName(coursename);
	    		  obj.setStudID(studid);
	    		  obj.setGrade(grade);
	    		  gc.add(obj);  		  
	    	  }
    	      
     }
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   return gc;
		}
}
