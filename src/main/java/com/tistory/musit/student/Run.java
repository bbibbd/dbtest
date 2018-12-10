package com.tistory.musit.student;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Options options = new Options();

		Scanner USERINPUT = new Scanner(System.in);
		options.printOptions();
		for(;;) {
			System.out.println("Choose the option");
			int option = USERINPUT.nextInt();
			USERINPUT.nextLine();

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
				break;
			else
				System.out.println("Choose a valid number");
		}
		USERINPUT.close();
	}
}
