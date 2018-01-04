package com.my.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Rollback a transaction with auto-commit set to true.
 * 
 * @author soufrk
 *
 */
public class RollbackProblem {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "INSERT INTO asset_category_bfl VALUES (?,?,?,?,?)";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    connection.setAutoCommit(true);
	    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	    preparedStatement.setInt(1, 12345);
	    preparedStatement.setString(2, "Y");
	    preparedStatement.setString(3, "ABCDEF");
	    preparedStatement.setString(4, "Y");
	    preparedStatement.setString(5, "Y");
	    int update = preparedStatement.executeUpdate();
	    System.out.println("Update:" + update);
	    Savepoint save1 = connection.setSavepoint();
	    
	    preparedStatement.setInt(1, 23456);
	    preparedStatement.setString(2, "N");
	    preparedStatement.setString(3, "BCDEFG");
	    preparedStatement.setString(4, "N");
	    preparedStatement.setString(5, "Y");
	    update = preparedStatement.executeUpdate();
	    System.out.println("Update:" + update);
	    Savepoint save2 = connection.setSavepoint();
	    
	    preparedStatement.setInt(1, 34567);
	    preparedStatement.setString(2, "Y");
	    preparedStatement.setString(3, "CDEFGH");
	    preparedStatement.setString(4, "N");
	    preparedStatement.setString(5, "Y");
	    update = preparedStatement.executeUpdate();
	    System.out.println("Update:" + update);
	    Savepoint save3 = connection.setSavepoint();
	    connection.rollback(save2);
	    connection.commit();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
