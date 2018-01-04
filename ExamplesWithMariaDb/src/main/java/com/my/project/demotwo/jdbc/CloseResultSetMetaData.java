package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Like Statement, ResultSet, PreparedStatement, etc. 
 * is it required to close ResultSetMetaData as well ?
 * 
 * @author soufrk
 *
 */
public class CloseResultSetMetaData {

    public static void main(String[] args) throws SQLException {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
	    while(resultSet.next()){
		System.out.println("Employee Name:" + resultSet.getString(1) + ", Employee-Id:" + resultSet.getInt(2));
	    }
	    resultSetMetaData.close();
	    resultSet.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (connection != null)
		connection.close();
	}
    }

}
