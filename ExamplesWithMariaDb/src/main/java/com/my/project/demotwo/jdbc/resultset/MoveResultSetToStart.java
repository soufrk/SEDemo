package com.my.project.demotwo.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * If iterating a ResultSet manually, how can you go back to the start.
 * 
 * @author soufrk
 *
 */
public class MoveResultSetToStart {

    public static void main1(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    System.out.println("Moved to next row successful:" + resultSet.next());
	    // Now the question arises, how can get back to the first row again.
	    // ??
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main2(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    System.out.println("Moved to next row successful:" + resultSet.next());
	    resultSet.beforeFirst();
	    // But, how do you verify ??
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    System.out.println("Moved to next row successful:" + resultSet.next());
	    System.out.println(resultSet.getRow());
	    resultSet.beforeFirst();
	    System.out.println(resultSet.getRow());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
