package com.tistory.musit.student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataManagement {
	private Connection conn;
	Statement stmt = null;
	private static String sorting = null;
	
	private final static String URL = "jdbc:mysql://104.155.151.3/test";
	private final static String ID = "root";
	private final static String PW = "root";


	
	public StudentDataManagement() {
		try {
			conn = DriverManager.getConnection(URL,ID,PW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Insert new data to the table
	public void insertStudent(StudentData student) {
		String sql = "insert into STUDENTINFO values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getMajor());
			pstmt.setString(5, student.getEmail());

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

	//update data from the table
	public void updateStudent(StudentData student) {
		String sql = "update STUDENTINFO set Name = ?, Gender = ? , Major = ?, eMail = ? where ID = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getGender());
			pstmt.setString(3, student.getMajor());
			pstmt.setString(4, student.getEmail());
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

	public StudentData selectOneStudent(String name) {  
		String sql = "select * from STUDENTINFO where Name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentData student = null;     
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				student = new StudentData();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("Name"));
				student.setGender(rs.getString("Gender"));
				student.setMajor(rs.getString("Major"));
				student.setEmail(rs.getString("eMail"));
			}       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		return student;  
	}

	public void selectALLStudents() {  
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from STUDENTINFO order by "+ sorting);
			int i = 1;
			while(result.next()) {
				System.out.println(i +".  "+ result.getString("ID")+"  /  "+result.getString("Name")+"  /  "+result.getString("Gender")+"  /  "+result.getString("Major")+"  /  "+result.getString("eMail"));
				i++;
			}

		} catch(Exception e){
			System.out.println("Error" + e);
		}

	} 
	
	public void sortBy(String sorting) {
		StudentDataManagement.sorting = sorting;
	}

/*
	public List<StudentData> selectAllStudent() {

		String sql = "select * from STUDENTINFO";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentData student = null;
		List<StudentData> studentList = new ArrayList<StudentData>();   
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				student = new StudentData();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("Name"));
				student.setGender(rs.getString("Gender"));
				student.setMajor(rs.getString("Major"));
				student.setEmail(rs.getString("eMail"));
				studentList.add(student);
			}       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		return studentList;
	}
	*/



}
