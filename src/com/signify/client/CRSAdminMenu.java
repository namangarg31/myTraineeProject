/**
 * 
 */
package com.signify.client;

import java.sql.Date;
import java.util.Scanner;

import com.signify.bean.*;
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
		 System.out.println("4. View Courses");
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
				   case 1:  
					        if(!ad.viewUnapproveStudents())
					        {
					        	System.out.println("Press 0 to approve all students : ");
					            System.out.println("Press 1 to approve single student : ");
					            int option = sc.nextInt();
						        switch(option)
						        { 
						           case 0:ad.approveStudent(0);
						        	      break;
						           case 1:System.out.println("Enter student id to approve : ");
						                  int sel = sc.nextInt();
						        	      ad.approveStudent(sel);
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
				            ad.addCourse(coursename,profid);
				            break;
				   case 3:  System.out.println("Enter the course name you want to remove : ");
		                    ch = sc.nextLine();
		                    coursename = sc.nextLine();
		                    ad.removeCourse(coursename);
				            break;
				   case 4:  ad.viewCourses();
					        break;         
				   case 5:  System.out.println("Enter new admin name : ");
				            String name = sc.next();
				            System.out.println("Set password : ");
				            String pass = sc.next();
				            ad.addAdmin(name, pass);
				            break; 
				   case 6: System.out.println("Enter professor name : ");
		                   name = sc.next();
		                   System.out.println("Enter password : ");
		                   pass = sc.next();
		                   System.out.println("Enter department name : ");
		                   String depart = sc.next();
		                   System.out.println("Enter designation name : ");
		                   String des = sc.next();
		                   ad.addProfessor(name,pass,depart,des);	
					       break;   
				   case 7: System.out.println("Enter student id for report card :");
				           int studid = sc.nextInt();
				           ad.generateReport(studid);
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
