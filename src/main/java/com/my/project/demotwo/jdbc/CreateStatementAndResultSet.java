package com.my.project.demotwo.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Simple demonstration of creation of <tt>Statement</tt> & <tt>ResultSet</tt>.
 * 
 * @author soufrk
 *
 */
public class CreateStatementAndResultSet {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mysql://localhost:3306/test";
	String uName = "root";
	String pWord = "mango";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();

	    /* execute(), returns boolean value. true returned by execute()
	     * doesn't mean there is result.
	     */ 
	    System.out.println(statement.execute("SELECT * FROM table_one WHERE id=-1"));
	    System.out.println(statement.execute("INSERT INTO table_one VALUES ('3','C')"));
	    
	    /* It is only used to differentiate an
	     * SQL Query vs Update. For updates, it returns false
	     */
	    if (statement.execute("INSERT INTO table_one VALUES ('2','B')")) {
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next())
		    System.out.println(resultSet.getString(1));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
