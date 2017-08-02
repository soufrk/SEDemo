package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * If you have guessed already the question is where and what exception is thrown
 * by this piece of code.
 * @author soufrk
 *
 */
public class ResultSetExceptionScenrio {

    public static void main(String[] args) throws SQLException {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/test";
	String uName = "root";
	String pWord = "tiger";
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM elapsed_time");
	    System.out.println(resultSet.getString(0));
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally{
	    if(connection != null)
		connection.close();
	}
    }

}
