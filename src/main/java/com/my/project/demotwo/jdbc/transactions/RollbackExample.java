package com.my.project.demotwo.jdbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Simple rollback example.
 * @author soufrk
 *
 */
public class RollbackExample {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "INSERT INTO employees VALUES (?,?,?,?,?)";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    connection.setAutoCommit(false);
	    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	    preparedStatement.setInt(1, 12345);
	    preparedStatement.setString(2, "ABCDE");
	    preparedStatement.setString(3, "abcd@defg.com");
	    preparedStatement.setDouble(4, 25000.00);
	    preparedStatement.setString(5, "9876543210");
	    int update = preparedStatement.executeUpdate();
	    // Check the DB here in debug mode.
	    System.out.println("Update:" + update);
	    connection.rollback();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
