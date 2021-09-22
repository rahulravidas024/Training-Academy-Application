package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Marks;
import com.model.Student;
import com.service.MarksService;
import com.service.MarksServiceImplementation;
import com.service.StudentService;
import com.service.StudentServiceImplementation;

public class Client {

	public static void main(String[] args) {
		String str;
		StudentService studentService = new StudentServiceImplementation();
		MarksService marksService = new MarksServiceImplementation();
		String emailpat = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String mobilepat = "\\d{10}";
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("**********************Training Academy************************");
			System.out.println();
			System.out.println(
					"  1. Show All Student Details\t\t\t  2. Show One Student Record\n  3. Add New Student\t\t\t\t  4. Update Student Details\n  5. Delete Student Record\n\n  6. Show All Student Marks\t\t\t  7. Show One Student Marks\n  8. Add Student Marks\t\t\t\t  9. Update Student Marks\n  10. Delete Student Marks");
			System.out.println();
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			List<Student> studentList = studentService.getAllStudent();
			Iterator<Student> itr = studentList.iterator();
			List<Marks> marksList = marksService.getAllMarks();
			Iterator<Marks> itr1 = marksList.iterator();
			switch (choice) {
			case 1:
				System.out.println("********************All Student Informations*********************");
				System.out.println();
				while (itr.hasNext()) {
					Student student = (Student) itr.next();
					System.out.println("Student Id: " + student.getStudentId());
					System.out.println("First Name: " + student.getFirstName());
					System.out.println("Last Name: " + student.getLastName());
					System.out.println("Date Of Birth: " + student.getDateOfBirth());
					System.out.println("Gender: " + student.getGender());
					System.out.println("Email ID: " + student.getEmailId());
					System.out.println("Mobile Number: " + student.getMobileNumber());
					System.out.println("Address: " + student.getAddress());
					System.out.println("Batch ID: " + student.getBatchId());
					System.out.println("-----------------------------------------------------------------------");
				}
				break;

			case 2: 
				System.out.println();
				System.out.println("Enter student ID number to show Record");
				int studentId = sc.nextInt();
				studentService.getStudent(studentId);
				System.out.println("------------------------------------------------------------------");
				break;
				
			case 3:
				String mobileNumber=null;
				String address = null;
				int batchId=0;
				System.out.println(" ");
				System.out.println("**************Insert Student information ************");
				System.out.println();
				System.out.print("Enter Student Id: ");
				studentId = sc.nextInt();
				System.out.print("Enter First Name: ");
				String firstName = sc.next();
				System.out.print("Enter Last Name: ");
				String lastName = sc.next();
				System.out.print("Enter Date Of Birth: ");
				String dateOfBirth = sc.next();
				System.out.print("Enter Gender: ");
				String gender = sc.next();
				System.out.print("Enter Email ID: ");
				String emailId = sc.next();
				
				while (!emailId.matches(emailpat))
				{
					System.out.println("Email is Not Vaild Please Type correct Email...........");
					emailId = sc.next();
				}
				
				System.out.print("Enter Mobile Number: ");
				mobileNumber = sc.next();
				
				while (!mobileNumber.matches(mobilepat))
				{
					System.out.println("Mobile Number is Not Vaild Try Again........");
					mobileNumber = sc.next();
				}
				
				System.out.print("Enter Address: ");
				address = sc.next();
				System.out.print("Enter Batch ID: ");
				batchId = sc.nextInt();
				
				Student student = new Student(studentId, firstName, lastName, dateOfBirth, gender, emailId,
						mobileNumber, address, batchId);
				int status = studentService.insertStudent(student);
				if (status > 0) {
					System.out.println("Student added successfully.......");
				} else {
					System.out.println("Unable to add student.......");
				}
				System.out.println("------------------------------------------------------------------");
				break;

			case 4:
				System.out.println("**************Update Student information ************");
				System.out.println();
				System.out.println("Enter Student Id to update: ");
				studentId = sc.nextInt();
				System.out.println("Enter First Name to update: ");
				firstName = sc.next();
				System.out.println("Enter Last Name to update: ");
				lastName = sc.next();
				System.out.println("Enter Date Of Birth to update: ");
				dateOfBirth = sc.next();
				System.out.println("Enter Gender to update: ");
				gender = sc.next();
				System.out.println("Enter Email ID to update: ");
				emailId = sc.next();
				
				while (!emailId.matches(emailpat))
				{
					System.out.println("Email is Not Vaild Please Type correct Email............");
					emailId = sc.next();
				}
				
				System.out.println("Enter Mobile Number to update: ");
				mobileNumber = sc.next();
				
				while (!mobileNumber.matches(mobilepat))
				{
					System.out.println("Mobile Number is Not Vaild Please Try Again........");
					mobileNumber = sc.next();
				}
				
				System.out.println("Enter Address to update: ");
				address = sc.next();
				System.out.println("Enter Batch ID to update: ");
				batchId = sc.nextInt();
				Student student1 = new Student(studentId, firstName, lastName, dateOfBirth, gender, emailId,
						mobileNumber, address, batchId);
				int status1 = studentService.updateStudent(student1);
				if (status1 > 0) {
					System.out.println("Student Updated successfully.......");
				} else {
					System.out.println("Unable to Update student.......");
				}
				System.out.println("------------------------------------------------------------------");
				break;

			case 5:
				System.out.println();
				System.out.println("Enter student ID number to delete Record");
				studentId = sc.nextInt();
				studentService.deleteStudent(studentId);
				System.out.println("Record Delete Successfully");
				System.out.println("------------------------------------------------------------------");
				break;
				

			case 6:
				System.out.println("**********All Students Marks*************");
				System.out.println();
				while (itr1.hasNext()) {
					Marks marks = itr1.next();
					System.out.println("Student Id: " + marks.getStudentId());
					System.out.println();
					System.out.println("English marks: " + marks.getEnglish());
					System.out.println("Physics Marks: " + marks.getPhysics());
					System.out.println("Chemistry Marks: " + marks.getChemistry());
					System.out.println("Maths Marks: " + marks.getMaths());
					System.out.println("Biology Marks: " + marks.getBiology());
					System.out.println();
					System.out.println("Total Marks: " + marks.getTotalMarks());
					System.out.println("Percentage: " + marks.getPercentage());
					System.out.println("------------------------------------------------------------------");
				}
				break;

			case 7: 
				System.out.println();
				System.out.println("Enter student ID number to show Marks");
				studentId = sc.nextInt();
				studentService.getName(studentId);
				marksService.getMarks(studentId);
				System.out.println("------------------------------------------------------------------");
				break;
				
			case 8:
				System.out.println(" ");
				System.out.println("**************Insert Marks ************");
				System.out.print("Enter Student Id: ");
				studentId = sc.nextInt();
				studentService.getName(studentId);
				System.out.println();
				System.out.print("Enter English Marks: ");
				int english = sc.nextInt();
				while (english<0 || english>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					english = sc.nextInt();
				}
				System.out.print("Enter Physics Marks: ");
				int physics = sc.nextInt();
				while (physics<0 || physics>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					physics = sc.nextInt();
				}
				System.out.print("Enter Chemistry Marks: ");
				int chemistry = sc.nextInt();
				while (chemistry<0 || chemistry>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					chemistry = sc.nextInt();
				}
				System.out.print("Enter Maths Marks: ");
				int maths = sc.nextInt();
				while (maths<0 || maths>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					maths = sc.nextInt();
				}
				System.out.print("Enter Bilogy Marks: ");
				int biology = sc.nextInt();
				while (biology<0 || biology>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					biology = sc.nextInt();
				}
				
				int totalMarks = english+physics+chemistry+maths+biology;
				float percentage = (float) (totalMarks/2.5);

				Marks marks = new Marks(studentId, english, physics, chemistry, maths, biology, totalMarks, percentage);
				int status2 = marksService.insertMarks(marks);
				if (status2 > 0) {
					System.out.println("Marks added successfully.......");
				} else {
					System.out.println("Unable to add marks.......");
				}
				System.out.println("------------------------------------------------------------------");
				break;

			case 9:
				System.out.println();
				System.out.println("Enter Student Id to update: ");
				studentId = sc.nextInt();
				studentService.getName(studentId);
				System.out.println();
				System.out.println("Enter English Marks to update: ");
				english = sc.nextInt();
				while (english<0 || english>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					english = sc.nextInt();
				}
				System.out.println("Enter Physics Marks to update: ");
				physics = sc.nextInt();
				while (physics<0 || physics>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					physics = sc.nextInt();
				}
				System.out.println("Enter Chemistry Marks to update: ");
				chemistry = sc.nextInt();
				while (chemistry<0 || chemistry>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					chemistry = sc.nextInt();
				}
				System.out.println("Enter Maths Marks to update: ");
				maths = sc.nextInt();
				while (maths<0 || maths>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					maths = sc.nextInt();
				}
				System.out.println("Enter Biology Marks to update: ");
				biology = sc.nextInt();
				while (biology<0 || biology>50)
				{
					System.out.println("Please Enter Marks between 0 to 50........Try Again........");
					biology = sc.nextInt();
				}
				
				totalMarks = english+physics+chemistry+maths+biology;
				percentage = (float) (totalMarks/2.5);
				
				Marks marks1 = new Marks(studentId, english, physics, chemistry, maths, biology, totalMarks, percentage);
				int status3 = marksService.updateMarks(marks1);
				if (status3 > 0) {
					System.out.println("Marks Updated successfully.......");
				} else {
					System.out.println("Unable to Update marks.......");
				}
				System.out.println("------------------------------------------------------------------");
				break;

			case 10:
				System.out.println();
				System.out.println("Enter student ID number to delete Marks Record");
				studentId = sc.nextInt();
				marksService.deleteMarks(studentId);
				System.out.println("Marks Record Delete Successfully");
				System.out.println("------------------------------------------------------------------");
				break;
				

			default:
				System.out.println("Enter Correct Number");

			}
			System.out.println();
			System.out.print("Do you wish to continue(y/n) ? ");
			str = sc.next();
		} while (str.equals("y") || str.equals("Y"));
		System.out.println("*******************Thank You****************************");
	}

}
