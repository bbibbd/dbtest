package com.tistory.musit.student;
import java.util.Scanner;

public class Run {
	
	public static void main(String[] args) {
	
	//StudentData student = new StudentData();
	Printer printer = new Printer();
	Options options = new Options();
	
	Scanner USERINPUT = new Scanner(System.in);

	printer.printOptions();
	int option = USERINPUT.nextInt();
	
	if(option == 1) 
		options.opt1SetStudent();
	else if(option == 2)
		options.opt2DeleteStudent();
	else if(option == 3)
		options.opt3UpdateStudentData();
	
	}
}
