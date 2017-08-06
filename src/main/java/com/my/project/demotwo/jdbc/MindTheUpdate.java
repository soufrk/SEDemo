package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

/**
 * Predict why update fails.
 * @author soufrk
 *
 */
public class MindTheUpdate {

    public static void main1(String[] args) throws SQLException {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/portal_mis";
	String uName = "root";
	String pWord = "tiger";
	Connection connection = null;
	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:mariadb://localhost:3306/portal_mis";
		String uName = "root";
		String pWord = "tiger";
		Connection connection = null;
		Formatter formatter = new Formatter();
		String format = "%5s%40s\n";
		try {
			String update = "SELECT * FROM elapsed_time";
			connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
			Statement statement = connection.createStatement(update);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				formatter.format(format, resultSet.getString(1), resultSet.getString(2));
				resultSet.next();
				formatter.format(format, resultSet.getString(1), resultSet.getString(2));
			}
			System.out.println(formatter);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
			connection.close();
		}
	}
}
