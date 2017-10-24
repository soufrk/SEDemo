package com.my.project.demotwo.jdbc.rowsets.connected;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Updating row set.
 * @author souvik.goswami
 *
 */
public class JdbcRowSetUpdating {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/employee";
	String uName = "root";
	String pWord = "tiger";
	String selectQuery = "SELECT * FROM employee WHERE dept = 'Software' AND desig = 'Engg'";
	
	try {
	    RowSetFactory factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(selectQuery);
	    rowSet.execute();
	    update(rowSet);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public static void update(JdbcRowSet rowSet) throws SQLException{
	//rowSet.absolute(0); Optional
	while(rowSet.next()){
	    rowSet.updateDouble("Salary", 5000.00D);
	    rowSet.updateRow();
	}
    }

}
