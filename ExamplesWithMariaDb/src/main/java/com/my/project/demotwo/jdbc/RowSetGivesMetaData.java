package com.my.project.demotwo.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Yes, <tt>RowSet</tt> returns a <tt>ResultSetMetaData</tt>.
 * 
 * @author soufrk
 *
 */
public class RowSetGivesMetaData {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "SELECT * FROM employees;";
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	    rowSet.execute();
	    
	    ResultSetMetaData resultSetMetaData = rowSet.getMetaData();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
