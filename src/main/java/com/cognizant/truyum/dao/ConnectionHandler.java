package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fis = null;
		Connection con = null;
		Properties props = new Properties();
		fis = new FileInputStream("src/main/resources/database.properties");

		props.load(fis);

		// load the Driver Class
		Class.forName(props.getProperty("driver"));

		// create the connection now
		con = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
				props.getProperty("password"));

		return con;

	}
}
