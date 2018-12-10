package com.tistory.musit.student;
import java.util.Scanner;

public class Options {
	
	StudentData student = new StudentData();
	Scanner USERINPUT = new Scanner(System.in);
	StudentDataManagement stm = new StudentDataManagement();
	
//option 1 - insert student information into database
	public void opt1SetStudent() {
		System.out.println("Input student ID");
		student.setId(USERINPUT.nextInt());
		USERINPUT.nextLine();
		System.out.println("Input student name");
		student.setName(USERINPUT.nextLine());
		System.out.println("Input gender (M/F)");
		student.setGender(USERINPUT.nextLine());
		System.out.println("Input major");
		student.setMajor(USERINPUT.nextLine());
		System.out.println("Input E-Mail");
		student.setEmail(USERINPUT.nextLine());
		stm.insertStudent(student);
		
		System.out.println("Sucessfully insterted student");
	}

//option 2 - delete student information from database
	public void opt2DeleteStudent() {
		try {
			System.out.println("Input student ID you want to delete");
			stm.deleteStudent(USERINPUT.nextInt());
			USERINPUT.nextLine();
			System.out.println("Susccessfully deleted student");
			
		}catch(Exception e) {
			System.out.println("Wrong studen ID "+ e);
		}
		
	}
	
//option 3 - update student information to database	
	public void opt3UpdateStudentData() {
		try {
			System.out.println("Input student ID you want to update");
			student.setId(USERINPUT.nextInt());
			USERINPUT.nextLine();	
			System.out.println("Input student name");
			student.setName(USERINPUT.nextLine());
			System.out.println("Input gender (M/F)");
			student.setGender(USERINPUT.nextLine());
			System.out.println("Input major");
			student.setMajor(USERINPUT.nextLine());
			System.out.println("Input E-Mail");
			student.setEmail(USERINPUT.nextLine());
			
			stm.updateStudent(student);

			
		} catch(Exception e) {
			System.out.println("Wrong student ID "+e);
		}
	}
	
}