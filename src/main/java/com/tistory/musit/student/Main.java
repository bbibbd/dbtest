package com.tistory.musit.student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TextUI tui = new TextUI();
		Scanner USERINPUT = new Scanner(System.in);
		Run run = new Run();
		
		for(;;) {
			tui.printFrontPage();
			System.out.println("Select option: ");
			int option = USERINPUT.nextInt();
			
			if(option == 1)		run.runAllStudent();
			else if(option == 2)	run.runDormitoryStudent();
			else if(option == 3) {
				System.out.println("Exit now. Hava a nice day!");
				break;
			}
			else	System.out.println("input valid value");
		}
		USERINPUT.close();
	}
}
