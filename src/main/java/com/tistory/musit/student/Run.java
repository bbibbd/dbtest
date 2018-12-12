package com.tistory.musit.student;
import java.util.Scanner;

public class Run {
	
	Options options = new Options();
	TextUI tui = new TextUI();
	DSoptions dsOptions = new DSoptions();
	Scanner USERINPUT = new Scanner(System.in);
	
	public void runAllStudent() {

		tui.printAllStudentOptions();
		for(;;) {
			System.out.println("Choose the option");
			int option = USERINPUT.nextInt();
			if(option == 1) 
				options.opt1SetStudent();
			else if(option == 2)
				options.opt2DeleteStudent();
			else if(option == 3)
				options.opt3UpdateStudentData();
			else if(option == 4) 
				options.opt4SelectOneSutdent();
			else if(option == 5)
				options.opt5SelectAllStudents();
			else if(option == 6)
				options.opt6SortingBy();
			else if(option == 7)
				options.opt7FilterBy();
			else if(option == 8)
				break;
			else if(option == 9) {
				System.out.println("Exit now. Have a nice day!");
				System.exit(0);
			}
			else	System.out.println("Input valid number");
			
		tui.printAllStudentOptions();
		}
	}
	
	public void runDormitoryStudent() {
		
		tui.printDormitoryStudentOptions();
		for(;;) {
			System.out.println("Choose the option");
			int option = USERINPUT.nextInt();
			USERINPUT.nextLine();
			if(option == 1) 
				dsOptions.opt1SetStudent();
			else if(option == 2)
				dsOptions.opt2DeleteStudent();
			else if(option == 3)
				dsOptions.opt3UpdateStudentData();
			else if(option == 4) 
				dsOptions.opt4SelectOneSutdent();
			else if(option == 5)
				dsOptions.opt5SelectAllStudents();
			else if(option == 6)
				dsOptions.opt6SortingBy();
			else if(option == 7)
				dsOptions.opt7FilterBy();
			else if(option == 8)
				break;
			else if(option == 9) {
				System.out.println("Exit now. Have a nice day!");
				System.exit(0);
			}
			else	System.out.println("Input valid number");
			
			tui.printDormitoryStudentOptions();
		}
	}
	
}
