package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The SQLException class contains specialized methods for getting
 * specific details about an exception.
 * 
 * You can play around modifying values and creating problems and
 * observing error details they cause.
 * 
 * @author soufrk
 *
 */
public class HandlingSqlExcption {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM a_table_that_does_not_exist");
	    int rowCount = -1;
	    if(resultSet.last())
		rowCount = resultSet.getRow();
	    System.out.println("Total number of rows:" + rowCount);
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    System.out.println(e.getSQLState());
	    System.out.println(e.getErrorCode());
	    System.out.println(e.getNextException());
	}
    }

}
