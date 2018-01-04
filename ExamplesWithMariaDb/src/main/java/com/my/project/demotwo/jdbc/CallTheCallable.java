package com.my.project.demotwo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Assuming the following definition of function in Mariadb
 * CREATE DEFINER=`root`@`localhost` FUNCTION `ShowEntryState`(stateString VARCHAR(10)) RETURNS varchar(10) CHARSET utf8
 * BEGIN 
 *     DECLARE entryState VARCHAR(10);
 *     IF stateString = 'N' THEN SET entryState='New';
 *     ELSEIF stateString = 'U' THEN SET entryState='Update';
 *     END IF;
 *     RETURN(entryState);
 * END
 * @author soufrk
 *
 */
public class CallTheCallable {

    public static void main(String[] args) throws SQLException {
	String jdbcUrl = "jdbc:mariadb://localhost:3307/test";
	String uName = "root";
	String pWord = "tiger";
	CallableStatement callableStatement = null;
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    callableStatement = connection.prepareCall("{? = call ShowEntryState(?)}");
	    // register OUT parameter
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, "N");
            callableStatement.execute();
            System.out.println(callableStatement.getString(1));
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if(connection != null)
		connection.close();
	}
    }

}
