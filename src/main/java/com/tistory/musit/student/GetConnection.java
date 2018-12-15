package com.tistory.musit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

	Statement stmt = null;
	
	protected String filterBy = "";
	protected String sorting = null;
	protected String idorname = null;
     
	protected Connection conn;
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://104.155.151.3/test";	//host url
	private final static String ID = "root";	//ID
	private final static String PW = "root";	//PW
	
	public GetConnection() {	
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ID,PW);	//connect to server
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occured while loading driver: "+e);
		}
		
	}
	
	//setter of filterBy variable
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	//setter of sorting variable
	public void sortBy(String sorting) {
		this.sorting = sorting;
	}

	//setter of idorname vvariable
	public void setIdorname(String idorname) {
		this.idorname = idorname;
	}


}
