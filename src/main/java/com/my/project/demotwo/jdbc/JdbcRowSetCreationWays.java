package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.JdbcRowSetImpl;

/**
 * JdbcRowSet is the only connected RowSet implementation.
 * Following are the 3 ways to create a JdbcRowset.
 * @author soufrk
 *
 */
public class JdbcRowSetCreationWays {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/innoviti_emi_staging";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "SELECT * FROM asset_category_staging WHERE risk_classification = 'A'";
	Connection connection = null;
	// 1st way, old.
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		    ResultSet.CONCUR_UPDATABLE);
	    ResultSet resultSet = statement.executeQuery(insertQuery);
	    JdbcRowSet rowSet = new JdbcRowSetImpl(resultSet);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	// 2nd way, old.
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    JdbcRowSet rowSet = new JdbcRowSetImpl(connection);
	    rowSet.setCommand(insertQuery);
	    rowSet.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	// 3rd and 
	// RowSet 1.1, Java SE 7
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	    rowSet.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
