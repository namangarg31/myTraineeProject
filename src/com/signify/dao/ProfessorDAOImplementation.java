/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.CourseNotAssignedException;
import com.signify.exception.FeePendingException;
import com.signify.exception.GradeAlreadyAddedException;
import com.signify.exception.NotTeachingExcetion;
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
	public List<Student> viewDAOEnrolledStudents(int id) throws CourseNotAssignedException
	{
		List<Student>students = new ArrayList<Student>();
		 try
		 {
			
		     String sql = "Select courseid from courses where Professorid="+id+"";
		     stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery(sql);
		     if(!rs.next()) {
		    	  throw new CourseNotAssignedException();
		     }
		     else
		     {
		    	 int course_id = rs.getInt("courseid");
			     System.out.println("Course ID is:"+course_id);
			     sql = "SELECT s.studentid,s.studentname,s.studentbranch,s.studentbatch FROM registeredcourse as r,student as s WHERE r.studentid = s.studentid AND r.courseCode="+course_id+"";
			     stmt = conn.prepareStatement(sql);
			     rs = stmt.executeQuery(sql);
			     while(rs.next())
		    	 {
		    		  int studentid = rs.getInt("studentid");
		    		  String studentname = rs.getString("studentname");
		    		  String studentbranch = rs.getString("studentbranch");
		    		  int studentbatch = rs.getInt("studentbatch");
		    		  Student obj = new Student();
		    		  obj.setUserId(studentid);
		    		  obj.setName(studentname);
		    		  obj.setBranch(studentbranch);
		    		  obj.setBatch(studentbatch);
		    		  students.add(obj);  
		    	 }
		     }
		 }
		 catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		 return students;
	}
	
	public void addDAOgrades(int proff_id,int student_id,String grade)throws CourseNotAssignedException,FeePendingException,NotTeachingExcetion
	{
		try
		{
			
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
		    	throw new CourseNotAssignedException();
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
                        		throw new GradeAlreadyAddedException();
                        	}
          			        sql = "UPDATE grade set grade='"+grade+"' where studid="+student_id+" and courseid="+cid;
          			        stmt = conn.prepareStatement(sql);
          			        stmt.executeUpdate(sql);	
                        }
                        else
                        {
                        	throw new FeePendingException();
                        }
		    		}
		    	}
		    	if(flag)
		    	{
		    		throw new NotTeachingExcetion();
		    	}
		    }
		}
		catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();     
		 }
   }
}
