package com.tistory.musit.student;
import java.util.Scanner;

public class Run {
	
	AllStudentOptions options = new AllStudentOptions();
	TextUI tui = new TextUI();
	DormStudentOptions dsOptions = new DormStudentOptions();
	Scanner USERINPUT = new Scanner(System.in);
	
	public void runAllStudent() {
		
		int option;
		do {
			tui.printAllStudentOptions();
			System.out.println("Choose the option");
			option = USERINPUT.nextInt();
			USERINPUT.nextLine();
			switch(option) {
			case 1: options.opt1SetStudent();		break;
			case 2:	options.opt2DeleteStudent();	break;
			case 3:	options.opt3UpdateStudentData();break;
			case 4:	options.opt4SelectOneSutdent();	break;
			case 5:	options.opt5PrintAllStudents();	break;
			case 6:	options.opt6SortingBy();		break;
			case 7:	options.opt7FilterBy();			break;
			case 8:	System.out.println();			break;
			case 9: 
				System.out.println("Exit now. Have a nice day!");
				System.exit(0);
			default:
				System.out.println("Input valid number");
				break;
			}
		}while(option != 8);
	}
	
	public void runDormitoryStudent() {
		
		int option;
		do {
			tui.printDormitoryStudentOptions();
			System.out.println("Choose the option");
			option = USERINPUT.nextInt();
			USERINPUT.nextLine();
			switch(option) {
			case 1: dsOptions.opt1SetStudent();			break;
			case 2:	dsOptions.opt2DeleteStudent();		break;
			case 3:	dsOptions.opt3UpdateStudentData();	break;
			case 4:	dsOptions.opt4SelectOneSutdent();	break;
			case 5:	dsOptions.opt5PrintAllStudents();	break;
			case 6:	dsOptions.opt6SortingBy();			break;
			case 7:	dsOptions.opt7FilterBy();			break;
			case 8:	System.out.println();				break;
			case 9: 
				System.out.println("Exit now. Have a nice day!");
				System.exit(0);
			default:
				System.out.println("Input valid number");
				break;
			}

		}while(option != 8);
	}
	
}
