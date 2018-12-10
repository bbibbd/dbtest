package com.tistory.musit.student;

public class Run {
	
	public static void main(String[] args) {
	
	StudentDataManagement stm = new StudentDataManagement();
	
	StudentData student = new StudentData();
	student.setId(21700071);
	student.setName("Gibeom Kim");
	student.setGender("M");
	student.setMajor("Computer Science and Electronical Engeeniering");
	student.setEmail("21700071@handong.edu");
	
	stm.insertStudent(student);
	
	for(int i=0; i<20; i++)
		System.out.println(stm.selectAllStudent());
	
	}
}
