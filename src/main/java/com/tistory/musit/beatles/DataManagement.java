package com.tistory.musit.beatles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManagement {
	private Connection conn;
	Statement stmt = null;
	private static String sorting = null;

	private final static String URL = "jdbc:mysql://104.155.151.3/test";
	private final static String ID = "root";
	private final static String PW = "root";

	public DataManagement() {
		try {
			conn = DriverManager.getConnection(URL,ID,PW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Insert new data to the table
	public void insertData(Data data) {
		String sql = "insert into STUDENTINFO values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data.getRank());
			pstmt.setString(2, data.getTitle());
			pstmt.setString(3, data.getAlbumTitle());
			pstmt.setString(4, data.getLeadVocal());
			pstmt.setString(5, data.getPrimarySongWritter());

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
	public void deleteData(int data) {
		String sql = "delete from beatles_rank where Title = ?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data);

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
	public void updateData(Data data) {
		String sql = "update STUDENTINFO set Rank = ?, Title = ? , Album = ?, Lead_Vocal = ?, Primary_Song_Writter where Title = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data.getRank());
			pstmt.setString(2, data.getTitle());
			pstmt.setString(3, data.getAlbumTitle());
			pstmt.setString(4, data.getLeadVocal());
			pstmt.setString(5, data.getPrimarySongWritter());
			pstmt.setString(6,  data.getTitle());

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

	public Data selectOneData(String title) {  
		String sql = "select * from STUDENTINFO where Title = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Data data = null;     
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				data = new Data();
				data.setRank(rs.getInt("Rank"));
				data.setTitle(rs.getString("Title"));
				data.setAlbumTitle(rs.getString("Album"));
				data.setLeadVocal(rs.getString("Lead_Vocal"));
				data.setPrimarySongWritter(rs.getString("Primary_Song_Writter"));
			}       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		return data;  
	}

	public void selectAllData() {  
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from beatles_rank order by "+ sorting);
			int i = 1;
			while(result.next()) {
				System.out.println(i +".  "+ result.getString("Rank")+"  /  "+result.getString("Title")+"  /  "+result.getString("Album")+"  /  "+result.getString("Lead_Vocal")+"  /  "+result.getString("Primary_Song_Writter"));
				i++;
			}

		} catch(Exception e){
			System.out.println("Error" + e);
		}

	} 

	public void sortBy(String sorting) {
		DataManagement.sorting = sorting;
	}

}