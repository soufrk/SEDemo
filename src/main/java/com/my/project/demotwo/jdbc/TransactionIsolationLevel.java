package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Since this is a very important field. Understand various enum value supports
 * from Oracle tutorials.
 * 
 * @author soufrk
 *
 */
public class TransactionIsolationLevel {

    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    System.out.println(connection.isValid(100));
	    if (connection.isValid(100)) {
		DatabaseMetaData dbms = connection.getMetaData();
		System.out.println(dbms.getDefaultTransactionIsolation());
		switch (dbms.getDefaultTransactionIsolation()) {
		case Connection.TRANSACTION_NONE:
		    System.out.println("TRANSACTION_NONE");
		    break;
		case Connection.TRANSACTION_READ_COMMITTED:
		    System.out.println("TRANSACTION_READ_COMMITTED");
		    break;
		case Connection.TRANSACTION_READ_UNCOMMITTED:
		    System.out.println("TRANSACTION_READ_UNCOMMITTED");
		    break;
		case Connection.TRANSACTION_REPEATABLE_READ:
		    System.out.println("TRANSACTION_REPEATABLE_READ");
		    break;
		case Connection.TRANSACTION_SERIALIZABLE:
		    System.out.println("TRANSACTION_SERIALIZABLE");
		    break;
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
