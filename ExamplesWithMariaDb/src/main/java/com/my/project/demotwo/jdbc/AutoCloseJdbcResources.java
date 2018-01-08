package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Can we use connection & statement in try-with-resources ?
 * 
 * @author soufrk
 *
 */
public class AutoCloseJdbcResources {

    /**
     *  So, the claim is Connection is auto-closed as of Java SE(JDBC 4.1)
     *  How do we prove this. Make a copy of the resource and check for null
     *  post try-cacth block.
     * @param args
     */
    public static void main1(String[] args) {
	final String jdbcUrl = "jdbc:mariadb://localhost:3306/employee";
	final String uName = "root";
	final String pWord = "tiger";
	Connection c = null;
	Statement s = null;
	try (Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
		) {
	    c = connection;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	System.out.println((c == null));
	System.out.println((s == null));
    }
    
    /**
     * Similarly, Statement & ResultSet are closed automatically as well.
     * @param args
     */
    public static void main2(String[] args) {
	final String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	final String uName = "root";
	final String pWord = "tiger";
	final String query = "SELECT * FROM employees";
	Connection c = null;
	Statement s = null;
	ResultSet r = null;
	try (Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query)) {
	    System.out.println(resultSet.next());
	    c = connection;
	    s = statement;
	    r = resultSet;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	System.out.println((c == null));
	System.out.println((s == null));
	System.out.println((r == null));
    }

}
