package com.medplus.departmentinfo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseConnection {

	static Connection con = null;

	static public Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/navnath";
		String uname = "root";
		String pwd = "root";
		/* Class.forName("com.mysql.jdbc.Driver"); */
		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
