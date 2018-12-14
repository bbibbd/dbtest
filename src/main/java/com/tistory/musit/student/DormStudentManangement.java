package com.tistory.musit.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DormStudentManangement extends GetConnection implements StudentDataManagement {
	//insert new student
	public void insertStudent(StudentData student) {
		String sql = "insert into Dormitory_Student_List"
				+ " values (?, ?, ?, ?, ?, ?)";	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, student.getId());	
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getGender());
			pstmt.setInt(4, student.getRoomNumber());
			pstmt.setInt(5, student.getBenefit());
			pstmt.setInt(6, student.getPenalty());

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
	
	//delete data from table
	public void deleteStudent(int studentID) {
		String sql = "delete from Dormitory_Student_List where ID = ?";

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

	//update data to the table
	public void updateStudent(StudentData student, int i) {
		String updateWhat="";
		if(i==1)	updateWhat = "Room_no";
		else if(i==2)	updateWhat = "Benefit";
		else	updateWhat ="Penalty";
		
		String sql = "update Dormitory_Student_List set "+updateWhat+" = ? where ID = ?";
		PreparedStatement pstmt = null;
		

		try {
			pstmt = conn.prepareStatement(sql);
			if(updateWhat =="Room_no")
				pstmt.setInt(1, student.getRoomNumber());
			else if(updateWhat =="Benefit")
				pstmt.setInt(1, student.getBenefit());
			else
				pstmt.setInt(1, student.getPenalty());
			
			pstmt.setInt(2, student.getId());
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

	//search one student
	public StudentData selectOneStudent(String name) {  
		String sql = "select * from Dormitory_Student_List where "+idorname+" = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StudentData student = null;   
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();

			while(result.next()) {
				student = new StudentData();
				student.setId(result.getInt("ID"));
				student.setName(result.getString("Name"));
				student.setGender(result.getString("Gender"));
				student.setRoomNumber(result.getInt("Room_no"));
				student.setBenefit(result.getInt("Benefit"));
				student.setPenalty(result.getInt("Penalty"));
			}       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		return student;  
	}

	//Show all student data
	public void printAllStudents() { 
		String sql = "select * from Dormitory_Student_List "+filterBy+" order by "+sorting;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			int i = 1;
			while(result.next()) {
				System.out.println("#"+i +".  \nStudent ID:  "
				+ result.getString("ID")+"\nName:  "
				+ result.getString("Name")+"\nGender:  "
				+ result.getString("Gender")+"\nRoom NO. "
				+ result.getString("Room_no")+"\nBenefit Score:  "
				+ result.getString("Benefit")+"\nPenalty Score:  "
				+ result.getString("Penalty")+"\n");
				i++;
			}

		} catch(Exception e){
			System.out.println("Error" + e);
		}
	}


}
