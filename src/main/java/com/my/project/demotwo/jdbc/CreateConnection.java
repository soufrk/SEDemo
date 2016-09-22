package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * How to connect to MariaDB 10.1 using Class 4 JDBC Driver.
 * Notice, how we don't require registration, using 
 * <pre><code>Class.forName(FullyQualifiedDriverName)</code></pre>
 * @author soufrk
 *
 */
public class CreateConnection {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		String uName = "root";
		String pWord = "mango";
		try{
			Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
			System.out.println(connection.isValid(100));
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
