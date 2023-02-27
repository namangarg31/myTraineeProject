/**
 * 
 */
package com.signify.client;

import java.util.List;
import java.util.Scanner;

import com.signify.bean.Student;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;

/**
 * @author Naman
 *
 */
public class CRSProfessorMenu {

	static public void displayMenu(int ID) {
		 System.out.println("WELCOME TO PROFESSOR MENU");
		 System.out.println("==========================");
		 System.out.println();
		 System.out.println("1.VIEW ENROLLED STUDENTS");
		 System.out.println("2.ADD GRADES");
		 System.out.println("3.EXIT");
		 boolean ex = false;
		 Scanner sc = new Scanner(System.in);
		 ProfessorInterface pi = new ProfessorService();
		 while(!ex)
		 {
			 System.out.println();
			 System.out.println("Enter your choice : ");
			 int choice = sc.nextInt();
			 try
			 {
				 switch(choice)
				 {
				   case 1:  List<Student>students = pi.viewEnrolledStudents(ID);
				            System.out.printf("---------------------------------------------------------------------------------------------%n");
				            System.out.printf("                                      ENROLLED STUDENTS                                      %n");
				            System.out.printf("---------------------------------------------------------------------------------------------%n");
				            System.out.printf("| %-20s | %-20s | %20s | %20s |", "STUDENTID", "STUDENTNAME", "STUDENTBRANCH","STUDENTBATCH");
				            System.out.println();
				            boolean flag = true;
				            for(Student student:students)
				            {
				            	flag = false;
				            	int studentid = student.getUserId();
				            	String studentname = student.getName();
				            	String studentbranch = student.getBranch();
				            	int studentbatch = student.getBatch();
				            	System.out.printf("| %-20s | %-20s | %20s | %20d |%n",studentid,studentname,studentbranch,studentbatch);
				            }
				            if(flag)
				            {
				            	System.out.printf("--------------------------------------NO STUDENTS HAVE ENROLLED YET--------------------------------%n");	
				            }
				            System.out.printf("---------------------------------------------------------------------------------------------%n");
		                    break;
				   case 2:  
					        System.out.println("Enter Student ID you want to grade for:");
			                int idd = sc.nextInt();
			                System.out.println("Enter grade you want to assign:");
			                String grade = sc.next();
			                pi.addGrade(ID,idd,grade);
		                    break;
				   case 3:  System.out.println();
					        System.out.println("THANK YOU FOR VISITING PROFESSOR MENU");
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
