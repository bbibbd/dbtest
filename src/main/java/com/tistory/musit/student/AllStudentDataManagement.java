package com.tistory.musit.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllStudentDataManagement extends GetConnection implements StudentDataManagement {

	//insert new student information to the server
	public void insertStudent(StudentData student) {	
		String sql = "insert into STUDENTINFO values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, student.getId());	
			pstmt.setString(2, student.getName());	
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getMajor());
			pstmt.setString(5, student.getPaid());

			pstmt.executeUpdate();	//update to the server
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}    
	}

	//delete student information from the server
	public void deleteStudent(int studentID) {
		String sql = "delete from STUDENTINFO where ID = ?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentID);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}   
	}

	//update student information from the table
	public void updateStudent(StudentData student, int i) {

		String updateWhat="";

		switch (i) {
			case 1: updateWhat =  "Name";	break;
			case 2: updateWhat = "Gender";	break;
			case 3: updateWhat = "Major";	break;
			case 4: updateWhat = "Paid";	break;
		}

		String sql = "update STUDENTINFO set "+updateWhat+" = ? where ID = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			switch(updateWhat) {
				case "Name":	pstmt.setString(1, student.getName());		break;
				case "Gender":	pstmt.setString(1, student.getGender());	break;
				case "Major":	pstmt.setString(1, student.getMajor());		break;
				case "Paid":	pstmt.setString(1, student.getPaid());		break;
			}
			pstmt.setInt(2, student.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}       
		finally {
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//search one student by id or name. 
	public StudentData selectOneStudent(String idOrName) {  
		String sql = "select * from STUDENTINFO where "
				+idorname+" = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StudentData student = null;     
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idOrName);

			result = pstmt.executeQuery();

			while(result.next()) {
				student = new StudentData();
				student.setId(result.getInt("ID"));
				student.setName(result.getString("Name"));
				student.setGender(result.getString("Gender"));
				student.setMajor(result.getString("Major"));
				student.setPaid(result.getString("Paid"));
			}       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		return student;  
	}

	//print all student information in the database
	public void selectALLStudents() { 
		String sql = "select * from STUDENTINFO "
				+filterBy+" order by "+sorting;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			int i = 1;
			while(result.next()) {
				System.out.println("#"+i +".  \nStudent ID:  "
						+ result.getString("ID")+"\nName:  "
						+ result.getString("Name")+"\nGender:  "
						+ result.getString("Gender")+"\nFaculty Of "
						+ result.getString("Major")+"\nPaid(O/X):  "
						+ result.getString("Paid")+"\n");

				i++;
			}
		} catch(Exception e){
			System.out.println("Error" + e);
		}
	} 


}
