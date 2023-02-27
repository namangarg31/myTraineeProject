package com.signify.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;
import com.signify.constants.SQLConstants;
import com.signify.exception.AlreadyRegisteredException;
import com.signify.exception.CourseFilledException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoSemesterRegisteration;
import com.signify.exception.SixRegisteredCoursesException;
import com.signify.service.StudentInterface;
import com.signify.utils.DBUtils;




public class StudentDAOImplementation implements StudentDAOInterface{
	
	
	 Connection conn = DBUtils.getConnection();
	 PreparedStatement stmt = null;
	 PreparedStatement stmt2 = null;
	 PreparedStatement stmt3 = null;
	 public int registerDAOStudent(String name,String password,String branch,int batch)
	 {
		   int studid = 0;   
		   try{
			   
			   
			      System.out.println("Connecting to database...");			      
			      stmt = conn.prepareStatement(SQLConstants.USER_INSERT);
			      stmt.setString(1,name);
			      stmt.setString(2,password);
			      stmt.setInt(3,2);
			      
			      stmt.executeUpdate();
			      stmt.close();
			      String sql2="select id from src.user where name='"+name+"' and password='"+password+"'";
			      
			 
			      stmt2 = conn.prepareStatement(sql2);
			      ResultSet rs = stmt2.executeQuery(sql2);
			      while(rs.next()){
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
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
		   return studid;
      }
	
	 public boolean isDAOVacant(int cid)
	 {
		 try
		 {

		      String qq = "select studentcount from courses where courseid="+cid;
		      stmt = conn.prepareStatement(qq);
		      ResultSet rr = stmt.executeQuery(qq);
		      if(rr.next()) {
		    	  int count = rr.getInt("studentcount");
		    	  if(count>=10) {
		    		  return false;
		    	  }
		      }
		 }
		 catch(SQLException se){
		      se.printStackTrace();
		   }
		   return true;
	 }
	 public boolean isSemDAORegister(int sem,int id)
	 {
		 try
		 {

		      String qq = "select * from semesterregisteration where semester="+sem+" and studentid="+id;
		      stmt = conn.prepareStatement(qq);
		      ResultSet rr = stmt.executeQuery(qq);
		      if(rr.next()) {
		    	  return true;
		      }
		 }
		 catch(SQLException se){
		      se.printStackTrace();
		   }
		   return false;
	 }
	 public void semDAORegister(int studid,int sem,String doj,int cid[])
	 {
			try{
				   				  
			      String q = "insert into semesterregisteration values(?,?,?)";			  
			      stmt = conn.prepareStatement(q);
			      stmt.setInt(1,studid);
			      stmt.setInt(2, sem);
			      stmt.setString(3, doj);
			      stmt.executeUpdate();   
			      for(int i=0;i<6;i++)
			      {
			    	  String sql = "insert into registeredcourse values(?,?,?,?,?)";
				      stmt = conn.prepareStatement(sql);
				      stmt.setInt(1,cid[i]);
				      stmt.setInt(2, sem);
				      stmt.setInt(3, studid);
				      stmt.setString(4,"NA");
				      stmt.setInt(5, 0);
				      stmt.executeUpdate();
				      String query1 = "update courses set studentcount = studentcount+1 where courseid="+cid[i];
				      stmt = conn.prepareStatement(query1);
				      stmt.executeUpdate(query1);
			      }    
			      			      
	     }
		catch(SQLException se){
		      se.printStackTrace();
		   }
		}
		 
	 public List<Course> viewDAOCatalog()throws CourseNotFoundException
	 {
		    List<Course>courses = new ArrayList<Course>();
			try{
			   
			      String q = "select * from courses";
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      boolean flag = true;
			      while(rs.next())
		    	  {
		    		  flag = false;
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
			      if(flag) {
			    	  throw new CourseNotFoundException();
			      }
			      
	     }
		catch(SQLException se){
		      se.printStackTrace();
		   }
			return courses;
		}
	 public void addDAOCourse(int studid,int cid)throws CourseFilledException,SixRegisteredCoursesException,AlreadyRegisteredException,NoSemesterRegisteration
	 {
			try{
				   			      
			      String qq = "select studentcount from courses where courseid="+cid;
			      stmt = conn.prepareStatement(qq);
			      ResultSet rr = stmt.executeQuery(qq);
			      if(rr.next()) {
			    	  int count = rr.getInt("studentcount");
			    	  if(count>=10) {
			    		  throw new CourseFilledException();
			    	  }
			    	  if(count>=10) {
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
			    		  throw new SixRegisteredCoursesException();
			    	  }
			    	  if(size>=6) {
			    		  return;
			    	  }
			    	  if(res.getInt("coursecode")==cid) {
			    		  throw new AlreadyRegisteredException(cid);
			    	  }
			    	  if(res.getInt("coursecode")==cid) {
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
				      String query1 = "update courses set studentcount = studentcount+1 where courseid="+cid;
				      stmt = conn.prepareStatement(query1);
				      stmt.executeUpdate(query1);
			      }
			      else {
			    	  throw new NoSemesterRegisteration();
			      }
	     }
		catch(SQLException se){
		      se.printStackTrace();
		}
	 }
	 public List<Course> myDAOCatalog(int studid)throws CourseNotFoundException
	 {
		    List<Course>courses = new ArrayList<Course>();
			try{
			      		      
			      String q = "select * from registeredcourse where studentid="+studid;
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      boolean flag = true;
			      while(rs.next())
		    	  {
		    		  flag = false;
		    		  int courseid = rs.getInt("coursecode");
		    		  String sem = rs.getString("semester");
		    		  int fee = 0;
		    		  String q1 = "select * from courses where courseid="+courseid;
				      stmt2 = conn.prepareStatement(q1);
				      ResultSet rs1 = stmt2.executeQuery(q1);
				      String coursename = "";
				      if(rs1.next()) {
				    	  coursename = rs1.getString("coursename");
				    	  fee = rs1.getInt("coursefee");
				      }
				      Course obj = new Course();
				      obj.setCourseId(courseid);
				      obj.setCourseName(coursename);
				      obj.setCourseFee(fee);
		    		  courses.add(obj);
		    		  
		    	  }
			      if(flag) {
			    	  throw new CourseNotFoundException();
			      }
	     }
		catch(SQLException se){
		      se.printStackTrace();
		   }
		   return courses; 
	 }
	 public void dropDAOCourse(int studid,int cid)
	 {
			try{
				   
			   
			      String q = "delete from registeredcourse where studentid="+studid+" and coursecode="+cid;
			      stmt = conn.prepareStatement(q);
			      stmt.executeUpdate(q);
			      System.out.println("Dropped Course - "+cid);
			      
			      String query = "update courses set studentcount = studentcount-1 where courseid="+cid;
			      stmt = conn.prepareStatement(query);
			      stmt.executeUpdate(query);
			      
	     }
		catch(SQLException se){
		      se.printStackTrace();
		   }
	 }
	 public boolean isDAOPaid(int studid, int semester) {
			try{
				   
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
			      
			}
		   catch(SQLException se){
		      se.printStackTrace();
		   }	
			return true;
		}
	 
	 public List<Course> feeDAOCatalog(int studid,int sem,int total_fees[])throws CourseNotFoundException
	 {
		    List<Course>courses = new ArrayList<Course>(); 
			try{
				    
			      int totalFee = 0;
			      
			      String q = "select * from registeredcourse where studentid="+studid + " and semester="+sem + " and feepaid=0";
			      stmt = conn.prepareStatement(q);
			      ResultSet rs = stmt.executeQuery(q);
			      boolean flag = true;
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
				      Course obj = new Course();
				      obj.setCourseId(courseid);
				      obj.setCourseName(coursename);
				      obj.setCourseFee(fees);
				      courses.add(obj);
		    	  }
			      if(flag) {
			    	  throw new CourseNotFoundException();
			      }
			      total_fees[0] = totalFee;
			      
	     }
		catch(SQLException se){
		      se.printStackTrace();
		   }
		   return courses;
		}
	 public void payDAOFee(int studid, int sem, int mode, int amt) {
			try{
				   
			      
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
			}
		catch(SQLException se){
		      se.printStackTrace();
		   }
		}
public void payDAOFeeOnline(int studid,int sem,int pay_choice,int amt,String cardType,String bankName,int cardNumber,String cardName,int cvv,String expiry)
{
	try{
		   
	      
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
	      
	      
	      
	      String sql2 = "SELECT coursecode,studentid from registeredcourse where feepaid=1 and semester="+sem+" and studentid="+studid;
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
	
	      
	}
  catch(SQLException se){
     se.printStackTrace();
   }
  }
}

