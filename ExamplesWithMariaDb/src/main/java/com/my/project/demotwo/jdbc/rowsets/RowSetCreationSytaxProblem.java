package com.my.project.demotwo.jdbc.rowsets;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * One of these syntax are correct way of instantiating a RowSet.
 * 
 * @author soufrk
 *
 */
public class RowSetCreationSytaxProblem {
    
    private static final String jdbcUrl = "A";
    private static final String uName = "B";
    private static final String pWord = "B";
    private static final String insertQuery = "D";
    
    public static void main(String[] args) {
	try {
	    RowSetFactory factory = new RowSetProvider().newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main2(String[] args) {
	try {
	    RowSetFactory factory = RowSetProvider.new Factory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public static void main3(String[] args) {
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main4(String[] args) {
	try {
	    RowSetProvider provider = RowSetFactory.newRowSetProvider();
	    RowSetFactory factory = new RowSetProvider().newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
