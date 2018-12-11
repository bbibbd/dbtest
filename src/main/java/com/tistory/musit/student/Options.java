package com.tistory.musit.student;

import java.util.Scanner;

public class Options {
	
	StudentData student = new StudentData();
	Scanner USERINPUT = new Scanner(System.in);
	StudentDataManagement stm = new StudentDataManagement();
	
//print options	
	public void printOptions() {
		System.out.println("--------------------------------------");
		System.out.println("-    options (7 to exit progrma)     -");
		System.out.println("======================================");
		System.out.println("-  1. Insert student data            -");
		System.out.println("-  2. Delete student data            -");
		System.out.println("-  3. Update student data            -");
		System.out.println("-  4. Search Student                 -");
		System.out.println("-  5. Print all studnet              -");
		System.out.println("-  6. Sorting                        -");
		System.out.println("--------------------------------------");
	}

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
		System.out.println("paid or not? (O/X)");
		student.setPaid(USERINPUT.nextLine());
		stm.insertStudent(student);
		
		System.out.println("Sucessfully insterted student");
	}

//option 2 - delete student information from database
	public void opt2DeleteStudent() {
		try {
			
			System.out.println("Input student ID you want to delete");

			stm.deleteStudent(USERINPUT.nextInt());
			USERINPUT.nextLine();
			
			USERINPUT.nextLine();
			System.out.println("Susccessfully deleted student");
			
		}catch(Exception e) {
			System.out.println("Wrong studen ID "+ e);
		}
		
	}
	
//option 3 - update student information to database	
	public void opt3UpdateStudentData() {
		System.out.println("Input student ID you want to update");
		int id = USERINPUT.nextInt();
		USERINPUT.nextLine();	
		try {
			student.setId(id);
			System.out.println("Input student name");
			student.setName(USERINPUT.nextLine());
			System.out.println("Input gender (M/F)");
			student.setGender(USERINPUT.nextLine());
			System.out.println("Input major");
			student.setMajor(USERINPUT.nextLine());
			System.out.println("Input E-Mail");
			student.setPaid(USERINPUT.nextLine());
			
			stm.updateStudent(student);

			
		} catch(Exception e) {
			System.out.println("student ID " + id +"does not exist");
		}
	}

//option 4 - search student 	
	public void opt4SelectOneSutdent() {
		
		System.out.println("Search student by (1) ID (2) Name. Input number");
		int number = USERINPUT.nextInt();
		USERINPUT.nextLine();
		
		String idOrName;
		if(number == 1) {
			idOrName = "ID";
			stm.setIdorname("ID");
		}
		else	{
			idOrName = "name";
			stm.setIdorname("Name");
		}
		
		System.out.println("Input student "+idOrName+" you want to search");
		String name = USERINPUT.nextLine();

		try {
		System.out.println("\nID: "+ stm.selectOneStudent(name).getId()+ "\nName: " 
				+ stm.selectOneStudent(name).getName()+"\nGender: "+ stm.selectOneStudent(name).getGender()
				+ "\nMajor: "+stm.selectOneStudent(name).getMajor()+ "\nPaid(O/X): "+stm.selectOneStudent(name).getPaid()+"\n");
		} catch(NullPointerException e) {
			System.out.println("There is no student named " + name + e);
		}
	}
	
	public void opt5SelectAllStudents(){
		System.out.println("#  /  Student ID  /  Name  /  Gender  /  Major  /  Paid (o/x)");
		System.out.println("----------------------------------------------------------------------------------------------");
		stm.selectALLStudents();
	}

	public void opt6SortingBy() {
		System.out.println("Sort by (1) ID (2) Name (3) Gender (4) Major (5) Paid or (6) Default. Input number: ");
		int userInput = USERINPUT.nextInt();
		if(userInput == 1)	stm.sortBy("ID");
		else if(userInput == 2)	stm.sortBy("Name");
		else if(userInput == 3) stm.sortBy("Gender");
		else if(userInput == 4) stm.sortBy("Major");
		else if(userInput == 5)	stm.sortBy("Paid");
		else stm.sortBy(null);
		System.out.println("Sorting comlpeted");
		
	}
	
}
