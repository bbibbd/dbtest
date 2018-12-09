package com.tistory.musit.dbtest;

import java.sql.*;
public class Opendb {

	public static void main(String[] args) {

		Connection conn;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = java.sql.DriverManager.getConnection("jdbc:mysql://104.155.151.3/test", "root", "root");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from beatles_rank");

			while(result.next()) {
				System.out.println(result.getString("Rank")+"  "+result.getString("Title")+"  "+result.getString("Album")+"  "+result.getString("Lead Vocal")+"  "+result.getString("Primary Song Writter"));
			}

		} catch(ClassNotFoundException e){
			System.out.println("Driver is not found" + e);
		}


		catch(Exception e) {
			System.out.println("¿À·ù" + e);
		} 
	}

}
