package com.tistory.musit.student;

import java.util.Scanner;

public class DormStudentOptions implements Options {
	
	TextUI tui = new TextUI();
	StudentData student = new StudentData();
	Scanner USERINPUT = new Scanner(System.in);
	DormStudentManangement stm = new DormStudentManangement();
	
	public void opt1SetStudent() {
		
		System.out.println("Input student ID");
		student.setId(USERINPUT.nextInt());
		USERINPUT.nextLine();
		System.out.println("Input student name");
		student.setName(USERINPUT.nextLine());
		System.out.println("Input gender (M/F)");
		student.setGender(USERINPUT.nextLine());
		System.out.println("Input Room Numer");
		student.setRoomNumber(USERINPUT.nextInt());
		USERINPUT.nextLine();
		System.out.println("Benefit Score: ");
		student.setBenefit(USERINPUT.nextInt());
		USERINPUT.nextLine();
		System.out.println("Penalty Score: ");
		student.setPenalty(USERINPUT.nextInt());
		USERINPUT.nextLine();
		
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
			System.out.println("Input student ID you want to update");
			int id = USERINPUT.nextInt();
			USERINPUT.nextLine();	
			
			System.out.println("Update student's (1)Room Number "
					+ "(2)Beneit Score (3)Penalty Score");
			int i = USERINPUT.nextInt();
			USERINPUT.nextLine();
			
			try {
				student.setId(id);
				
				if(i==1) {
					System.out.println("Input new room number: ");
					student.setRoomNumber(USERINPUT.nextInt());
				}
				else if(i==2) {
					System.out.println("Input benefit score");
					student.setBenefit(USERINPUT.nextInt());
				}
				else {
					System.out.println("Input penalty score");;
					student.setPenalty(USERINPUT.nextInt());
				}
				USERINPUT.nextLine();
				stm.updateStudent(student, i);
			} catch(Exception e) {
				System.out.println("student ID " + id +"does not exist");
			}
		}
		
		//option 4 - search student 	
		public void opt4SelectOneSutdent() {
			
			System.out.println("Search student by (1) ID (2) Name. "
					+ "Input number");
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
			System.out.println("Searching...");
			System.out.println("\nID: "+ stm.selectOneStudent(name).getId()+ "\nName: " 
					+ stm.selectOneStudent(name).getName()+"\nGender: "
					+ stm.selectOneStudent(name).getGender()
					+ "\nRoom No: "+stm.selectOneStudent(name).getRoomNumber()
					+ "\nBenefit Score: "+stm.selectOneStudent(name).getBenefit()
					+"\nPenalty Score: "+stm.selectOneStudent(name).getPenalty()
					+"\n");
			} catch(NullPointerException e) {
				System.out.println("There is no student " +idOrName+" "+name +". "+ e);
			}
		}

		//option 5 - print all the student information
		public void opt5PrintAllStudents(){
			System.out.println("------------------------------------"
					+ "----------------------------------------------------------");
			stm.printAllStudents();
		}
		
		//option 6 - Sorting
		public void opt6SortingBy() {
			System.out.println("Sort by (1) ID (2) Name (3) Gender "
					+ "(4) Room Number (5) Benefit Score (6) Penalty Score or"
					+ " (7) Default. Input number: ");
			int userInput = USERINPUT.nextInt();
			
			switch(userInput) {
			case 1:
			}
			if(userInput == 1)	stm.sortBy("ID");
			else if(userInput == 2)	stm.sortBy("Name");
			else if(userInput == 3) stm.sortBy("Gender");
			else if(userInput == 4) stm.sortBy("Room_no");
			else if(userInput == 5)	stm.sortBy("Benefit");
			else if(userInput == 6) stm.sortBy("Penalty");
			else stm.sortBy(null);
			System.out.println("Sorting comlpeted");
		}
		
		//option 7 - filtering
		public void opt7FilterBy() {
			int number1;
			String filterBy = null;
			System.out.println("(1) Equlas to "
					+ "(2) Benefit/Penalty score from ... to ... (3) Default");
			number1 = USERINPUT.nextInt();
			USERINPUT.nextLine();
			
			if(number1 == 1) {
				System.out.println("filter by (1) Gender (2) Room Number");
				int number2 = USERINPUT.nextInt();
				USERINPUT.nextLine();
				System.out.println("Input Value");
				String value = USERINPUT.nextLine();
			
				if(number2 == 1)	filterBy = " where '"+value+"' = Gender";
				else	filterBy = " where '"+value+"' = Room_no";
			}
			
			else if(number1 == 2) {
				System.out.println("(1) Benefit (2) Penalty: ");
				int number2 = USERINPUT.nextInt();
				USERINPUT.nextLine();
				System.out.println(" A to B. Input value A");
				int a = USERINPUT.nextInt();
				USERINPUT.nextLine();
				
				System.out.println("Input Value B");
				int b = USERINPUT.nextInt();
				USERINPUT.nextLine();
				
				if(number2==1)	filterBy = " where Benefit between "+a+" and "+b;
				else	filterBy = " where Penalty between "+a+" and "+b;
			}
			else	filterBy = "";
			
			stm.setFilterBy(filterBy);
			System.out.println("filtering completed.");
			
		}
		
		public void opt8PrintFrontPage() {
			tui.printFrontPage();
		}
}
