/**
 * 
 */
package com.signify.client;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.*;
import com.signify.exception.CourseNotFoundException;
import com.signify.service.AdminInterface;
import com.signify.service.AdminService;

/**
 * @author Naman
 *
 */
public class CRSAdminMenu {
	static public void displayMenu(int ID)
	{
		 System.out.println("WELCOME TO ADMIN MENU");
		 System.out.println("==========================");
		 System.out.println();
		 System.out.println("1. Approve the student registration");
		 System.out.println("2. Add Course");
		 System.out.println("3. Remove Course");
		 System.out.println("4. View Course");
		 System.out.println("5. Add Admin");
		 System.out.println("6. Add Professor");
		 System.out.println("7. Generate Report Card");
         System.out.println("8. Exit\n");
		 boolean ex = false;
		 Scanner sc = new Scanner(System.in);
		 AdminInterface ad = new AdminService();
		 while(!ex)
		 {
			 System.out.println();
			 System.out.println("Enter your choice : ");
			 int choice = sc.nextInt();
			 try
			 {
				 switch(choice)
				 {
				  case 1: List<Student>students = ad.viewUnapproveStudents();
						  System.out.printf("---------------------------------------------------------------------------------------------%n");
					      System.out.printf("                                  STUDENTS LEFT FOR APPROVAL                                 %n");
					      System.out.printf("---------------------------------------------------------------------------------------------%n");
					      System.out.printf("| %-20s | %-20s | %20s | %20s |", "STUDENTID", "STUDENTBRANCH", "STUDENTNAME","STUDENTBATCH");
					      System.out.println();
					      boolean flag = true;
				    	  for(Student student : students)
				    	  {
				    		  flag = false;
				    		  int studentid  = student.getUserId();
						      String studentbranch = student.getBranch();
						      String studentname = student.getName();
						      int studentbatch = student.getBatch();
				    		  System.out.printf("| %-20d | %-20s | %20s | %20d |%n",studentid,studentbranch,studentname,studentbatch);
				    		  
				    	  }					      
					      if(flag) {
					      System.out.printf("---------------------------------------------------------------------------------------------%n");	  
					      System.out.println("                                      APPROVAL IS CLEAR                                       ");
					      }
					      System.out.printf("---------------------------------------------------------------------------------------------%n");
					      
						        if(!flag)
						        {
						        	System.out.println("Press 0 to approve all students : ");
						            System.out.println("Press 1 to approve single student : ");
						            int option = sc.nextInt();
							        switch(option)
							        { 
							           case 0: boolean f = ad.approveStudent(0);
							           		   if(f) System.out.println("All students are approved successfully....");
							        	       break;
							           case 1: System.out.println("Enter student id to approve : ");
							                   int sel = sc.nextInt();
							        	       f = ad.approveStudent(sel);
							        	       if(f) System.out.println("Student is approved successfully....");
							        	       break;
							           default : System.out.println("Invalid selection");	      
							        }
						        }
                            break;
				   case 2:  System.out.println("Enter the course name you want to register : ");
				            String ch = sc.nextLine();
				            String coursename = sc.nextLine();
				            System.out.println("Enter the professor id for the course : ");
				            int profid = sc.nextInt();
				            boolean f = ad.addCourse(coursename,profid);
				            if(f) System.out.println("Course added successfully....");
				            break;
				   case 3:  System.out.println("Enter the course name you want to remove : ");
		                    ch = sc.nextLine();
		                    coursename = sc.nextLine();
		                    f = ad.removeCourse(coursename);
		                    if(f) System.out.println("Course removed successfully....");
				            break;
				   case 4:  List<Course>courses = ad.viewCourses();
						    flag = true;
						    System.out.printf("---------------------------------------------------------------------------------------------%n");
						    System.out.printf("                                        COURSE CATALOG                                      %n");
						    System.out.printf("---------------------------------------------------------------------------------------------%n");
						    System.out.printf("| %-20s | %-20s | %20s | %20s |", "COURSEID", "COURSENAME", "STUDENTCOUNT","PROFESSORID");
						    System.out.println();
					        for(Course course:courses)
				    	    {
				    		  flag = false;
				    		  int courseid = course.getCourseId();
				    		  coursename = course.getCourseName();
				    		  int studentcount = course.getStudentCount();
				    		  int professorid = course.getProfessorId();
				    		  System.out.printf("| %-20s | %-20s | %20d | %20d |%n",courseid,coursename,studentcount,professorid);
				    		  
				    	     }
						      if(flag) {
						    	  System.out.println("                      NO COURSE FOUND                                                      ");
						      }
						      System.out.printf("---------------------------------------------------------------------------------------------%n");
					        break;         
				   case 5:  System.out.println("Enter new admin name : ");
				            String name = sc.next();
				            System.out.println("Set password : ");
				            String pass = sc.next();
				            int aid = ad.addAdmin(name, pass);
				            System.out.println("Admin is added successfully.....");
						    System.out.println("Your user id is : "+aid);
						    System.out.println("");
				            break; 
				   case 6: System.out.println("Enter professor name : ");
		                   name = sc.next();
		                   System.out.println("Enter password : ");
		                   pass = sc.next();
		                   System.out.println("Enter department name : ");
		                   String depart = sc.next();
		                   System.out.println("Enter designation name : ");
		                   String des = sc.next();
		                   int pid = ad.addProfessor(name,pass,depart,des);	
		                   System.out.println("Professor is added successfully.....");
		 			       System.out.println("Your user id is : "+pid);
		 			       System.out.println("");
					       break;   
				   case 7: System.out.println("Enter student id for report card :");
				           int studid = sc.nextInt();
				           List<GradeCard>gc = ad.generateReport(studid);
				           System.out.printf("---------------------------------------------------------------------------------------------%n");
						   System.out.printf("                                        GRADE CARD                                      %n");
						   System.out.printf("---------------------------------------------------------------------------------------------%n");
						   System.out.printf("| %-20s | %-20s | %20s | %20s |", "COURSEID", "COURSENAME", "STUDENTID","GRADE");
						   System.out.println();
						   for(GradeCard obj : gc) {
							   int courseid = obj.getCourseID();
							   coursename = obj.getCourseName();
							   String grade = obj.getGrade();
							   System.out.printf("| %-20d | %-20s | %20d | %20s |%n",courseid,coursename,studid,grade);
						   }
						   System.out.printf("---------------------------------------------------------------------------------------------%n");
						   System.out.println();
					       break;
				   case 8: System.out.println();
			               System.out.println("THANK YOU FOR VISITING ADMIN MENU");
			               System.out.println();
			               ex = true;
			               CRSApplicationMenu obj = new CRSApplicationMenu();
			               obj.displayApplicationMenu();	   
					        
				   default: System.out.println("Invalid selection");	        
				 }
			 }
			 catch(Exception e)
			 {
				 System.out.println("Exception occurred");
			 }
			 finally
			 {
				 ex = false;  
			 }
		 }
	}
}
