package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImplementation;

public class Client {

	public static void main(String[] args) {
		String str;
		StudentService studentService = new StudentServiceImplementation();
		
		do {
		Scanner sc=new Scanner(System.in);
		System.out.println("*******************Training Academy********************");
		System.out.println("  1. Show Student Details\n  2. Add New Student\n  3. Modify Student Details\n  4. Delete Student Record");
		System.out.print("Enter Your Choice: ");
		int choice = sc.nextInt();
		
		List<Student> studentList = studentService.getAllStudent();
		Iterator<Student> itr = studentList.iterator();
		switch(choice)
		{
		case 1:
			System.out.println("**********All Student Informations*************");
			while (itr.hasNext()) 
			{
				Student student = (Student) itr.next();
				System.out.println("Student Id: "+ student.getStudentId());
				System.out.println("First Name: "+ student.getFirstName());
				System.out.println("Last Name: "+ student.getLastName());
				System.out.println("Date Of Birth: "+ student.getDateOfBirth());
				System.out.println("Gender: "+ student.getGender());
				System.out.println("Email ID: "+ student.getEmailId());
				System.out.println("Mobile Number: "+ student.getMobileNumber());
				System.out.println("Address: "+ student.getAddress());
				System.out.println("------------------------------------------------------------------");	
			}
			break;
			
			case 2:
			System.out.println(" ");
			System.out.println("**************Insert Student information ************");
			System.out.print("Enter Student Id: ");
			int studentId=sc.nextInt();
			System.out.print("Enter First Name: ");
			String firstName=sc.next();
			System.out.print("Enter Last Name: ");
			String lastName=sc.next();
			System.out.print("Enter Date Of Birth: ");
			String dateOfBirth=sc.next();
			System.out.print("Enter Gender: ");
			String gender=sc.next();
			System.out.print("Enter Email ID: ");
			String emailId=sc.next();
			System.out.print("Enter Mobile Number: ");
			long mobileNumber=sc.nextLong();
			System.out.print("Enter Address: ");
			String address=sc.next();
						
			Student student = new Student(studentId, firstName, lastName, dateOfBirth, gender, emailId, mobileNumber, address);
			int status=studentService.insertStudent(student);
			if(status>0) {
				System.out.println("Student added successfully.......");
			}
			else
			{
				System.out.println("Unable to add student.......");
			}
			System.out.println("------------------------------------------------------------------");	
			break;
			
			  case 3:
				    System.out.println("Enter Student Id to update: ");
					studentId=sc.nextInt();
					System.out.println("Enter First Name to update: ");
					firstName=sc.next();
					System.out.println("Enter Last Name to update: ");
					lastName=sc.next();
					System.out.println("Enter Date Of Birth to update: ");
					dateOfBirth=sc.next();
					System.out.println("Enter Gender to update: ");
					gender=sc.next();
					System.out.println("Enter Email ID to update: ");
					emailId=sc.next();
					System.out.println("Enter Mobile Number to update: ");
					mobileNumber=sc.nextLong();
					System.out.println("Enter Address to update: ");
					address=sc.next();
					Student student1 = new Student(studentId, firstName, lastName, dateOfBirth, gender, emailId, mobileNumber, address);
					int status1=studentService.updateStudent(student1);
					if(status1>0) {
						System.out.println("Student Updated successfully.......");
					}
					else
					{
						System.out.println("Unable to Update student.......");
					}
					System.out.println("------------------------------------------------------------------");	
			     break;
			     
			  case 4:
				  System.out.println("Enter student ID number to delete Record");
				  studentId = sc.nextInt();
				  studentService.deleteStudent(studentId);
				  System.out.println("Record Delete Successfully");
				  System.out.println("------------------------------------------------------------------");	
				  break;
			   
			}
			System.out.println();
				System.out.print("Do you wish to continue(y/n) ? ");
				str=sc.next();
			}while(str.equals("y")||str.equals("Y"));
		System.out.println("*******************Thank You****************************");
	}

}
