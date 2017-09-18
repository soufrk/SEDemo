import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Demonstrates scrolling behaviour of a RowSet
 * 
 * Observe behaviour with a query that returns,
 * only single row
 * two rows
 * @author souvik.goswami
 *
 */
public class JdbcRowSetScrolling {
    public static void main(String[] args) {
	String jdbcUrl = "jdbc:mariadb://localhost:3306/employee";
	String uName = "root";
	String pWord = "tiger";
	String insertQuery = "SELECT * FROM `employee` WHERE `dept` = 'Software'";
	RowSetFactory factory = null;
	
	try {
	    factory = RowSetProvider.newFactory();
	    JdbcRowSet rowSet = factory.createJdbcRowSet();
	    rowSet.setUrl(jdbcUrl);
	    rowSet.setUsername(uName);
	    rowSet.setPassword(pWord);
	    rowSet.setCommand(insertQuery);
	    rowSet.execute();
	    
	    //System.out.println(rowSet.next());
	    if(rowSet.next()){
		System.out.println("----------- Row 1 --------------");
		System.out.format("Column 1: %s\n", rowSet.getString(1));
		System.out.format("Column 2: %s\n", rowSet.getString(2));
		System.out.format("Column 3: %s\n", rowSet.getString(3));
		System.out.format("Column 4: %s\n", rowSet.getString(4));
	    }
	    if(rowSet.next()){
		System.out.println("----------- Row 2 --------------");
		System.out.format("Column 1: %s\n", rowSet.getString(1));
		System.out.format("Column 2: %s\n", rowSet.getString(2));
		System.out.format("Column 3: %s\n", rowSet.getString(3));
		System.out.format("Column 4: %s\n", rowSet.getString(4));
	    }
	    if(rowSet.previous()){
		System.out.println("----------- Row 1 --------------");
		System.out.format("Column 1: %s\n", rowSet.getString(1));
		System.out.format("Column 2: %s\n", rowSet.getString(2));
		System.out.format("Column 3: %s\n", rowSet.getString(3));
		System.out.format("Column 4: %s\n", rowSet.getString(4));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
}
