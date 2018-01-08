package com.my.project.demotwo.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Total number of rows the result-set is holding, without traversing ?
 * 
 * @author soufrk
 *
 */
public class HowManyColumnsResultSetReturns {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
	    int rowCount = -1;
	    if(resultSet.last()) // tries to move the cursor to the last row
		rowCount = resultSet.getRow(); // returns the index of current row
	    System.out.println("Total number of rows:" + rowCount);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
