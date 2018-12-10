package com.tistory.musit.beatles;
import java.util.Scanner;

public class Options {
	
	Data songs = new Data();
	Scanner USERINPUT = new Scanner(System.in);
	DataManagement stm = new DataManagement();
	
//print options	
	public void printOptions() {
		System.out.println("--------------------------------------");
		System.out.println("-    options (7 to exit progrma)     -");
		System.out.println("======================================");
		System.out.println("-  1. Insert songs data              -");
		System.out.println("-  2. Delete songs data              -");
		System.out.println("-  3. Update songs data              -");
		System.out.println("-  4. Select One songs               -");
		System.out.println("-  5. Print all studnet              -");
		System.out.println("-  6. Sorting                        -");
		System.out.println("--------------------------------------");
	}

//option 1 - insert songs information into database
	public void opt1SetSongs() {
		System.out.println("Input songs ID");
		songs.setRank(USERINPUT.nextInt());
		USERINPUT.nextLine();
		System.out.println("Input songs title");
		songs.setTitle(USERINPUT.nextLine());
		System.out.println("Input gender (M/F)");
		songs.setAlbumTitle(USERINPUT.nextLine());
		System.out.println("Input major");
		songs.setLeadVocal(USERINPUT.nextLine());
		System.out.println("Input E-Mail");
		songs.setPrimarySongWritter(USERINPUT.nextLine());
		stm.insertData(songs);
		
		System.out.println("Sucessfully insterted songs");
	}

//option 2 - delete songs information from database
	public void opt2DeleteSongs() {
		try {
			System.out.println("Input songs ID you want to delete");
			stm.deleteData(USERINPUT.nextInt());
			USERINPUT.nextLine();
			System.out.println("Susccessfully deleted songs");
			
		}catch(Exception e) {
			System.out.println("Wrong studen ID "+ e);
		}
		
	}
	
//option 3 - update songs information to database	
	public void opt3UpdateData() {
		System.out.println("Input songs ID you want to update");
		int id = USERINPUT.nextInt();
		USERINPUT.nextLine();	
		try {
			songs.setRank(id);
			System.out.println("Input songs title");
			songs.setTitle(USERINPUT.nextLine());
			System.out.println("Input album title ");
			songs.setAlbumTitle(USERINPUT.nextLine());
			System.out.println("Input major");
			songs.setLeadVocal(USERINPUT.nextLine());
			System.out.println("Input E-Mail");
			songs.setPrimarySongWritter(USERINPUT.nextLine());
			
			stm.updateData(songs);

			
		} catch(Exception e) {
			System.out.println("songs ID " + id +"does not exist");
		}
	}

//option 4 - show one songs data 	
	public void opt4SelectOneSong() {
		
		System.out.println("Input songs title you want to search");
		String title = USERINPUT.nextLine();

		try {
		System.out.println("ID: "+ stm.selectOneData(title).getRank()+ "\ttitle: " 
				+ stm.selectOneData(title).getTitle()+"\t Gender: "+ stm.selectOneData(title).getAlbumTitle()
				+ "\nMajor: "+stm.selectOneData(title).getLeadVocal()+ "\tE-Mail: "+stm.selectOneData(title).getPrimarySongWritter());
		} catch(NullPointerException e) {
			System.out.println("There is no songs titled " + title + e);
		}
	}
	
	public void opt5SelectAllsongss(){
		System.out.println("#  /  songs ID  /  title  /  Gender  /  Major  /  eMail");
		System.out.println("----------------------------------------------------------------------------------------------");
		stm.selectAllData();
	}

	public void opt6SortingBy() {
		System.out.println("Sort by (1) Title (2) Album (3) Lead Vocal (4) Primary Song Writter (5) Default. Input number: ");
		int userInput = USERINPUT.nextInt();
		if(userInput == 1)	stm.sortBy("Title");
		else if(userInput == 2)	stm.sortBy("Album");
		else if(userInput == 3) stm.sortBy("Lead_Vocal");
		else if(userInput == 4)	stm.sortBy("Primary_Song_Writter");
		else stm.sortBy(null);
		System.out.println("Sorting comlpeted");
		
	}
	
}
