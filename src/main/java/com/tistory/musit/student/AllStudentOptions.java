package com.tistory.musit.student;

import java.util.Scanner;

public class AllStudentOptions implements Options {

	TextUI tui = new TextUI();
	StudentData student = new StudentData();	//instantiate StudentData as student
	AllStudentDataManagement stm = new AllStudentDataManagement();
	Scanner USERINPUT = new Scanner(System.in);	//instantiate Scanner as USERINPUT

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
		System.out.println("Update student's (1)Namge "
				+ "(2)Gender (3)Major (4) Paid");	
		try {
			student.setId(id);
			int i;
			do {
				i = USERINPUT.nextInt();
				USERINPUT.nextLine();
				switch(i) {
				case 1:
					System.out.println("Input name: ");
					student.setName(USERINPUT.nextLine());
					break;
				case 2: 
					System.out.println("Input gender");
					student.setGender(USERINPUT.nextLine());
					break;
				case 3:
					System.out.println("Input major");
					student.setMajor(USERINPUT.nextLine());
					break;
				case 4: 
					System.out.println("paid? (O/X)");
					student.setPaid(USERINPUT.nextLine());
					break;
				default:
					System.out.println("Wrong number. Input valid number");
					break;
				}
			}while (i<1 || i>4);
			stm.updateStudent(student, i);
			System.out.println("Update completed\n");
		} catch(Exception e) {
			System.out.println("student ID " + id +"does not exist");
		}
	}

	//option 4 - search student 	
	public void opt4SelectOneSutdent() {

		System.out.println("Search student by (1) ID (2) Name. Input number");

		String idOrName = "";
		int number;
		do {
			number = USERINPUT.nextInt();
			USERINPUT.nextLine();
			switch (number) {
			case 1:
				idOrName = "ID";
				stm.setIdorname("ID");
				break;
			case 2:
				idOrName = "name";
				stm.setIdorname("Name");
				break;
			default:
				System.out.println("input valid number");
				break;
			}
		}while(number<1 || number>2);

		System.out.println("Input student "+idOrName+" you want to search");
		String name = USERINPUT.nextLine();

		try {
			System.out.println("Searching...");
			System.out.println("\nID: "+ stm.selectOneStudent(name).getId()
					+ "\nName: " + stm.selectOneStudent(name).getName()
					+"\nGender: "+ stm.selectOneStudent(name).getGender()
					+ "\nMajor: "+stm.selectOneStudent(name).getMajor()
					+ "\nPaid(O/X): "+stm.selectOneStudent(name).getPaid()+"\n");
		} catch(NullPointerException e) {
			System.out.println("There is no student "+idOrName +" "+ name + e);
		}
	}

	//option 5 - print all the student information
	public void opt5PrintAllStudents(){
		System.out.println("----------------------------"
				+ "--------------------------------------"
				+ "----------------------------");
		stm.printAllStudents();
		System.out.println("-----------------------------"
				+ "---------------------------------------"
				+ "--------------------------");
	}

	//option 6 - Sorting
	public void opt6SortingBy() {
		System.out.println("Sort by (1) ID (2) Name (3) Gender "
				+ "(4) Major (5) Paid or (6) Default. "
				+ "Input number: ");
		int i;
		do {
			i = USERINPUT.nextInt();
			USERINPUT.nextLine();
			switch(i) {
			case 1:	stm.sortBy("ID");		break;
			case 2:	stm.sortBy("Name");		break;
			case 3: stm.sortBy("Gender");	break;
			case 4: stm.sortBy("Major");	break;
			case 5:	stm.sortBy("Paid");		break;
			case 6: stm.sortBy(null);		break;
			default: 
				System.out.println("Input valid nubmer");
				break;
			}
		}while(i<1 || i>6);
		System.out.println("Sorting comlpeted");
	}

	//option 7 - filtering
	public void opt7FilterBy() {
		int number1;
		String filterBy = null;
		System.out.println("(1) Equlas to (2) ID from ... to ... (3) Default");
		number1 = USERINPUT.nextInt();
		USERINPUT.nextLine();

		if(number1 == 1) {
			System.out.println("filter by (1) Gender (2) Faculty (3) Paid");
			int number2 = USERINPUT.nextInt();
			USERINPUT.nextLine();
			System.out.println("Input Value");
			String value = USERINPUT.nextLine();

			if(number2 == 1)	filterBy = " where '"+value+"' = Gender";
			else if(number2 == 2)	filterBy = " where '"+value+"' = Major";
			else	filterBy = " where '"+value+"' = Paid";
		}

		else if(number1 == 2) {
			System.out.println("ID from A to B. Input value A");
			int a = USERINPUT.nextInt();
			USERINPUT.nextLine();

			System.out.println("Input Value B");
			int b = USERINPUT.nextInt();
			USERINPUT.nextLine();

			filterBy = " where ID between "+a+" and "+b;
		}
		else	filterBy = "";

		stm.setFilterBy(filterBy);
		System.out.println("filtering completed.");

	}
}
