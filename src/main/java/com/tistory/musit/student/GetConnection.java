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
	private final static String URL = "jdbc:mysql://104.155.151.3/test";	//host url
	private final static String ID = "root";	//ID
	private final static String PW = "root";	//PW

	//connect to the server when instantiate this class
	public GetConnection() {	
		try {
			conn = DriverManager.getConnection(URL,ID,PW);	//connect to server
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
