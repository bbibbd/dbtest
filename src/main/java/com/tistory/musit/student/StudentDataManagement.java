package com.tistory.musit.student;

public interface StudentDataManagement {
	
	public void insertStudent(StudentData student);
	public void deleteStudent(int studentID);
	public void updateStudent(StudentData student, int i);
	public StudentData selectOneStudent(String idOrName);
	public void printAllStudents();
	
}
