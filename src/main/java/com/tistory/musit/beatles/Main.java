package com.tistory.musit.beatles;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

		Options options = new Options();

		Scanner USERINPUT = new Scanner(System.in);
		options.printOptions();
		for(;;) {
			System.out.println("Choose the option");
			int option = USERINPUT.nextInt();
			USERINPUT.nextLine();

			if(option == 1) 
				options.opt1SetSongs();
			else if(option == 2)
				options.opt2DeleteSongs();
			else if(option == 3)
				options.opt3UpdateData();
			else if(option == 4) 
				options.opt4SelectOneSong();
			else if(option == 5)
				options.opt5SelectAllsongss();
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
