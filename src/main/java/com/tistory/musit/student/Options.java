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

//option 4 - show one student data 	
	public void opt4SelectOneSutdent() {
		
		System.out.println("Input student name you want to search");
		String name = USERINPUT.nextLine();

		try {
		System.out.println("ID: "+ stm.selectOneStudent(name).getId()+ "\tName: " 
				+ stm.selectOneStudent(name).getName()+"\t Gender: "+ stm.selectOneStudent(name).getGender()
				+ "\nMajor: "+stm.selectOneStudent(name).getMajor()+ "\tE-Mail: "+stm.selectOneStudent(name).getEmail());
		} catch(NullPointerException e) {
			System.out.println("There is no student named " + name + e);
		}
		
		
	}
	
}
