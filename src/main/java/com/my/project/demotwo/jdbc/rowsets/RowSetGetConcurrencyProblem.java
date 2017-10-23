package com.my.project.demotwo.jdbc.rowsets;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Trying to fetch concurrency before executing a result-set leads
 * to a null-pointer-exception.
 * @author soufrk
 *
 */
public class RowSetGetConcurrencyProblem {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/innoviti_emi_staging";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "SELECT * FROM asset_category_staging WHERE risk_classification = 'A'";
	//Connection connection = null;
	// 3rd and 
	// RowSet 1.1, Java SE 7
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	    printProperties(rowSet);
	    rowSet.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void printProperties(JdbcRowSet rowSet) throws SQLException{
	System.out.println(rowSet.getType());
	System.out.println(rowSet.getConcurrency());
	System.out.println(rowSet.getEscapeProcessing());
	System.out.println(rowSet.getMaxRows());
	System.out.println(rowSet.getQueryTimeout());
	System.out.println(rowSet.getShowDeleted());
	System.out.println(rowSet.getTransactionIsolation());
	System.out.println(rowSet.getTypeMap());
    }

}
