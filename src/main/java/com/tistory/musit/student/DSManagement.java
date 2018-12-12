package com.tistory.musit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DSManagement {
	
	private Connection conn;
	Statement stmt = null;
	
	private String filterBy = "";
	private String sorting = null;
	private String idorname = null;
	
	private final static String URL = "jdbc:mysql://104.155.151.3/test";
	private final static String ID = "root";
	private final static String PW = "root";
	
	public DSManagement() {
		try {
			conn = DriverManager.getConnection(URL,ID,PW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertStudent(DormitoryStudentData student) {
		String sql = "insert into Dormitory_Student_List values (?, ?, ?, ?, ?, ?)";
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

	//update data from the table
	public void updateStudent(DormitoryStudentData student, int i) {
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
	public DormitoryStudentData selectOneStudent(String name) {  
		String sql = "select * from Dormitory_Student_List where "+idorname+" = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		DormitoryStudentData student = null;   
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();

			while(result.next()) {
				student = new DormitoryStudentData();
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
	public void selectALLStudents() { 
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
	
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public void sortBy(String sorting) {
		this.sorting = sorting;
	}

	public void setIdorname(String idorname) {
		this.idorname = idorname;
	}
}
