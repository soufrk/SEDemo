package com.my.project.demotwo.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Simple demonstration of creation of <tt>Statement</tt> & <tt>ResultSet</tt>.
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
			/*ResultSet resultSet = statement.executeQuery("SELECT * FROM table_one");
			while (resultSet.next()) {
				System.out.println("Id:" + resultSet.getString(1) + " Name:" + resultSet.getString(2));
			}*/
			
			// execute(), returns boolean value.
			//System.out.println(statement.execute("SELECT * FROM table_one"));
			
			/* true returned by execute() doesn't mean there is result.
			 * It is only used to differentiate an SQL Query vs Update.
			 * For updates, it returns false
			 */
			System.out.println(statement.execute("SELECT * FROM table_one WHERE id=-1"));
			System.out.println(statement.execute("INSERT INTO table_one VALUES ('3','C')"));
			
			/*if(statement.execute("INSERT INTO table_one VALUES ('2','B')")){
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next())
					System.out.println(resultSet.getString(1));
			}*/
						
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
