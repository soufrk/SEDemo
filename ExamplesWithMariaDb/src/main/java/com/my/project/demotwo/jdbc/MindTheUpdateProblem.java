package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

/**
 * Predict why update fails.
 * 
 * @author soufrk
 *
 */
public class MindTheUpdateProblem {
    
    public static void main(String[] args) throws SQLException {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	Connection connection = null;
	Formatter formatter = new Formatter();
	String format = "%5s%40s\n";
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement1 = connection.createStatement();
	    ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM employee");
	    if (resultSet1 != null) {
		resultSet1.next();
		formatter.format(format, resultSet1.getString(1), resultSet1.getString(2));
		resultSet1.next();
		formatter.format(format, resultSet1.getString(1), resultSet1.getString(2));
	    }
	    String update = "UPDATE employee SET salary = salary + 500";
	    Statement statement2 = connection.createStatement(update);
	    ResultSet resultSet2 = statement2.executeQuery();
	    if(resultSet2 == null){
		System.out.println("Updates !!");
	    }
	    System.out.println(formatter);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (connection != null)
		connection.close();
	}
    }
}
