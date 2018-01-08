package com.my.project.demotwo.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Now, that you can move the 1st row in a ResultSet, how do you move to the last row ?
 * 
 * @author soufrk
 *
 */
public class MoveToLastRow {

    public static void main1(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    while(resultSet.next()){/*Traverse without any action*/}
	    // But now you have traversed all the rows.
	    // Even the last one !!
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
	    // Thankfully there's one utility method of ResultSet to the rescue.
	    int totalCount = resultSet.getFetchSize();
	    while(resultSet.next() && totalCount-->1){/*Traverse without any action*/}
	    System.out.println(resultSet.getRow());
	    // Or is it ?
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main3(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    // Seems like this dragged into more problems.
	    int totalCount = resultSet.getFetchSize();
	    int currentCount = 0;
	    while(resultSet.next()){/*Traverse without any action*/currentCount++;}
	    System.out.println(totalCount);
	    System.out.println(currentCount);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main4(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    // So a traversal once through the ResultSet is required to determine it's size.
	    int totalCount = resultSet.getFetchSize();
	    int currentCount = 0;
	    while(resultSet.next()){/*Traverse without any action*/currentCount++;}
	    System.out.println(totalCount);
	    System.out.println(currentCount);
	    // But still the cursor has moved past last row.
	    // How to go back just one row ??
	    // Another traversal ??
	    resultSet.first();
	    while(currentCount-- >1)resultSet.next();
	    System.out.println(resultSet.getRow());
	    // Or could we simplify this ?
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main5(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    resultSet.last();
	    System.out.println(resultSet.getRow());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
