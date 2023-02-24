package com.signify.client;


import java.util.*;
import java.util.Scanner;

import com.signify.bean.User;
import com.signify.service.StudentInterface;
import com.signify.service.StudentService;
import com.signify.service.UserInterface;
import com.signify.service.UserService;

/**
 * @author Naman
 *
 */

public class CRSApplicationMenu {
	
//	static UserService us1 = new UserService();
	static void displayApplicationMenu()
	{
		 System.out.println("WELCOME TO CRS APPLICATION");
		 System.out.println("==========================");
		 System.out.println();
		 System.out.println("MAIN MENU");
		 System.out.println();
		 System.out.println("1.LOGIN");
		 System.out.println("2.REGISTERATION FOR STUDENT");
		 System.out.println("3.UPDATE PASSWORD");
		 System.out.println("4.EXIT");
		 boolean ex = false;
         UserInterface user = new UserService(); 
         StudentInterface student = new StudentService();
		 while(!ex)
		 {
			 Scanner sc = new Scanner(System.in);
			 System.out.println();
			 System.out.println("Enter your choice : ");    	
     	     try
		     {
				 int choice = sc.nextInt();
				 switch(choice)
				 {
				   case 1:  System.out.println("Enter UserID : ");
							int userID = sc.nextInt();
							System.out.println("Enter Password : ");
							String password = sc.next();
							System.out.println("Enter Role : ");
							String role = sc.next();
							role = role.toLowerCase();
					        user.userLogin(userID,password,role);
				            break;
				   case 2:  System.out.println("Enter username : ");
		                    String name = sc.next();
		                    System.out.println("Enter Password : ");
							password = sc.next();
		                    System.out.println("Enter branch : ");
		                    String branch = sc.next();
		                    System.out.println("Enter batch : ");
		                    int batch = sc.nextInt();
			                student.registerForStudent(name,password,branch,batch);
		                    break;
				   case 3:  System.out.println("Enter user ID : ");
				            userID = sc.nextInt();
					        System.out.println("Enter old password : ");
				            String oldpass = sc.next();
				            System.out.println("Enter new password : ");
				            String newpass = sc.next();
				            user.updatePassword(userID,oldpass,newpass);
				   			break;
				   case 4:   System.out.println();
						     System.out.println("THANK YOU FOR VISITING CRS APPLICATION");
						     ex = true;
						     System.exit(0);
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
	 public static void main(String args[])
	 {
          displayApplicationMenu();
	 }
}
