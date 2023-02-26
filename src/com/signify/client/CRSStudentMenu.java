/**
 * 
 */
package com.signify.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


import com.signify.service.StudentInterface;
import com.signify.service.StudentService;
import com.signify.service.UserService;

/**
 * @author Naman
 *
 */
public class CRSStudentMenu {

	
	static public void displayMenu(int ID) {
		 System.out.println("WELCOME TO STUDENT MENU");
		 System.out.println("==========================");
		 System.out.println();
		 System.out.println("1.SEMESTER REGISTERATION");
		 System.out.println("2.ADD COURSE");
		 System.out.println("3.DROP COURSE");
		 System.out.println("4.MY CATALOG");
		 System.out.println("5.PAY FEE");
		 System.out.println("6.EXIT");
		 boolean ex = false;
		 Scanner sc = new Scanner(System.in);
		 StudentInterface student = new StudentService();
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
				            System.out.println("Semester you want to register in :");
				            int sem = sc.nextInt();
				            if(student.isSemRegister(sem,ID))
				            {
				            	System.out.println("You have already registered to this semester....");
				            }
				            else
				            {
				            	String doj = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					            student.viewCatalog();
					            int[] courseid = new int[6];
					            for(int i=1;i<=4;i++)
					            {
					            	boolean mark = true;
					            	while(mark)
					            	{
					            		System.out.println("Enter the course "+i+" you want register in :");
							            int courseID = sc.nextInt();
							            if(student.isVacant(courseID))
							            {
							            	courseid[i-1] = courseID;
							            	mark = false;
							            }
							            else
							            {
							            	System.out.println("Course is already filled....Renter the course ID");
							            }
					            	}
					            }				            
					            for(int i=1;i<=2;i++)
					            {
					            	boolean mark = true;
					            	while(mark)
					            	{
					            		System.out.println("Enter the alternate course "+i+"you want register in :");
							            int courseID = sc.nextInt();
							            if(student.isVacant(courseID))
							            {
							            	courseid[i+3] = courseID;
							            	mark = false;
							            }
							            else
							            {
							            	System.out.println("Course is already filled....Renter the course ID");
							            }
					            	}
					            }	
					            student.semReg(ID, sem, doj, courseid);
				            }
				            break;
				   case 2:  student.viewCatalog();  
		                    System.out.println("Enter courseID to add :");
		                    int cid = sc.nextInt();
					        student.addCourse(ID,cid);
				            break;
				   case 3:  student.myCatalog(ID);
			                System.out.println("Enter courseID to drop :");
			                cid = sc.nextInt();
						    student.dropCourse(ID,cid);
					        break;
				   case 4:  student.myCatalog(ID);
	                        break;
				   case 5:  System.out.println("Enter which semester you want to pay for : ");
				            int semm = sc.nextInt();
				            if(student.isPaid(ID, semm)) {
				            	System.out.println("NO PENDING FEE!!");
				            	break;
				            }
				            System.out.println("Fees to be paid for semester "+semm+"");
				            int total_fees[] = {0};
			            	student.feeCatalog(ID, semm,total_fees);
			            	System.out.println("Choose how you want to pay the fees");
			            	System.out.println("1.Online 2.Offline");
			            	int pay_choice = sc.nextInt();
			            	boolean check = true;
			            	
			            	switch(pay_choice) {
			            	    case 1:
			            	    	System.out.println("WELCOME TO ONLINE MODE OF PAYMENT");
			            	    	System.out.println("=================================");
			            	    	System.out.println("Enter amount to be paid : ");
			            	    	int amount = sc.nextInt();
			            	    	while(amount!=total_fees[0])
			            	    	{
			            	    		System.out.println("INVALID AMOUNT ENTERED !!!!");
			            	    		System.out.println("Re-enter amount : ");
			            	    		amount = sc.nextInt();
			            	    	}
			            	    	System.out.println("Enter card type : ");
			            	    	String cardType = sc.next();
			            	    	System.out.println("Enter bank name : ");
			            	    	String bankName = sc.next();
			            	    	System.out.println("Enter card number : ");
			            	    	int cardNumber = sc.nextInt();
			            	    	System.out.println("Enter name on card : ");
			            	    	String ch = sc.nextLine();
			            	    	String cardName = sc.nextLine();
			            	    	System.out.println("Enter cvv : ");
			            	    	int cvv = sc.nextInt();
			            	    	System.out.println("Enter expiry date : ");
			            	    	String expiry = sc.next();
			            	    	student.payFeeOnline(ID,semm,pay_choice,amount,cardType,bankName,cardNumber,cardName,cvv,expiry);
			            	    	break;
			            	    case 2:
			            	    	System.out.println("WELCOME TO OFFLINE MODE OF PAYMENT");
			            	    	System.out.println("=================================");
			            	    	System.out.println("Enter amount to be paid : ");
			            	    	int amountt = sc.nextInt();
			            	    	while(amountt!=total_fees[0])
			            	    	{
			            	    		System.out.println("INVALID AMOUNT ENTERED !!!!");
			            	    		System.out.println("Re-enter amount : ");
			            	    		amount = sc.nextInt();
			            	    	}
			            	    	student.payFee(ID,semm,pay_choice,amountt);
			            	    	break;
			            	    default:
			            	    	System.out.println("Invalid selection");
			            	
			            	}	
				            break;
				   case 6:  System.out.println();
					        System.out.println("THANK YOU FOR VISITING STUDENT MENU");
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
