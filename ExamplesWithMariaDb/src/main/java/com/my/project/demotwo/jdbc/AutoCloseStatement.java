package com.my.project.demotwo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Can we use connection & statement in try-with-resources ?
 * 
 * @author soufrk
 *
 */
public class AutoCloseStatement {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/employee";
	String uName = "root";
	String pWord = "tiger";
	Connection c = null;
	Statement s = null;
	try (Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
		Statement statement = connection.createStatement();) {
	    c = connection;
	    s = statement;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	System.out.println((c == null));
	System.out.println((s == null));
    }

}
