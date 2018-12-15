package com.tistory.musit.student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TextUI tui = new TextUI();
		Scanner USERINPUT = new Scanner(System.in);
		Run run = new Run();
		
		int option;
		do {
			tui.printFrontPage();
			System.out.println("Select option: ");
			option = USERINPUT.nextInt();
			USERINPUT.nextLine();
			
			switch(option) {
			case 1:	run.runAllStudent(); break;
			case 2: run.runDormitoryStudent(); break;
			case 3:
				System.out.println("Exit now. Hava a nice day!");
				break;
			default:	
				System.out.println("input valid value");
				break;	
			}
		}while(option != 3);
		USERINPUT.close();
		System.exit(0);
	}
}
