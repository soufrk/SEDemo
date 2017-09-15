package com.my.project.demotwo.jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

/**
 * CachedRowSet = basic disconnected row-set
 * WebRowSet = CachedRowSet + read/write XML to transform itself
 * JoinRowSet = WebRowSet + do JOIN while being disconnected
 * FilteredRowSet = WebRowSet + apply filters to data held
 *
 * Also, watch for the imports closely.
 * @author souvik.goswami
 *
 */
public class DisconnectedRowSet {
    
    public static void main(String[] args) {
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    printProperties(factory.createCachedRowSet());
	    printProperties(factory.createWebRowSet());
	    printProperties(factory.createJoinRowSet());
	    printProperties(factory.createFilteredRowSet());
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void printProperties(RowSet rowSet) throws SQLException{
	System.out.println("-------------------");
	System.out.println(rowSet.getType());
	System.out.println(rowSet.getConcurrency());
	System.out.println(rowSet.getEscapeProcessing());
	System.out.println(rowSet.getMaxRows());
	System.out.println(rowSet.getQueryTimeout());
	//System.out.println(rowSet.getShowDeleted());
	System.out.println(rowSet.getTransactionIsolation());
	System.out.println(rowSet.getTypeMap());
    }

}
