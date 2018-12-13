package com.tistory.musit.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDataManagement extends GetConnection {
	
	//insert new student information to the server
	public void insertStudent(AllStudentData student) {	
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
	public void updateStudent(AllStudentData student) {
		String sql = "update STUDENTINFO set Name = ?, Gender = ? , Major = ?, Paid = ? where ID = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getGender());
			pstmt.setString(3, student.getMajor());
			pstmt.setString(4, student.getPaid());
			pstmt.setInt(5, student.getId());

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

	//search one student by id or name. 
	public AllStudentData selectOneStudent(String name) {  
		String sql = "select * from STUDENTINFO where "+idorname+" = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		AllStudentData student = null;     
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			result = pstmt.executeQuery();

			while(result.next()) {
				student = new AllStudentData();
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
	
	//print all student information which is registered in the database
	public void selectALLStudents() { 
		String sql = "select * from STUDENTINFO "+filterBy+" order by "+sorting;
		
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
