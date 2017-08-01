package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

public class DatabaseMetaDataIntro {

    private static Formatter FORMATTER;
    private static final String FORMAT = "%d. %-54s - %-30s\n";
    private static int COUNTER;
    static {
	FORMATTER = new Formatter();
	COUNTER = 1;
    }

    public static void main(String[] args) {
	// String jdbcUrl = "jdbc:mysql://localhost:3306/test";
	String jdbcUrl = "jdbc:mariadb://localhost:3306/portal_mis";
	String uName = "root";
	String pWord = "tiger";
	try {
	    Connection connection = DriverManager.getConnection(jdbcUrl, uName, pWord);
	    DatabaseMetaData metaData = connection.getMetaData();
	    addToFormatter("allProceduresAreCallable()", metaData.allProceduresAreCallable());
	    addToFormatter("allTablesAreSelectable()", metaData.allTablesAreSelectable());
	    addToFormatter("autoCommitFailureClosesAllResultSets()", metaData.autoCommitFailureClosesAllResultSets());
	    addToFormatter("dataDefinitionCausesTransactionCommit()", metaData.dataDefinitionCausesTransactionCommit());
	    addToFormatter("dataDefinitionIgnoredInTransactions()", metaData.dataDefinitionIgnoredInTransactions());
	    addToFormatter("deletesAreDetected(ResultSet.TYPE_FORWARD_ONLY)",
		    metaData.deletesAreDetected(ResultSet.TYPE_FORWARD_ONLY));
	    addToFormatter("deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE)",
		    metaData.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
	    addToFormatter("deletesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE)",
		    metaData.deletesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));
	    addToFormatter("doesMaxRowSizeIncludeBlobs()()", metaData.doesMaxRowSizeIncludeBlobs());
	    addToFormatter("getCatalogSeparator()", metaData.getCatalogSeparator());
	    addToFormatter("getCatalogTerm()", metaData.getCatalogTerm());
	    addToFormatter("getDatabaseMajorVersion()", metaData.getDatabaseMajorVersion());
	    addToFormatter("getDatabaseMinorVersion()", metaData.getDatabaseMinorVersion());
	    addToFormatter("getDatabaseProductName()", metaData.getDatabaseProductName());
	    addToFormatter("getDatabaseProductVersion()", metaData.getDatabaseProductVersion());
	    addToFormatter("getDefaultTransactionIsolation()", metaData.getDefaultTransactionIsolation());
	    addToFormatter("getDriverMajorVersion()", metaData.getDriverMajorVersion());
	    addToFormatter("getDriverMinorVersion()", metaData.getDriverMinorVersion());
	    addToFormatter("getDriverName()", metaData.getDriverName());
	    addToFormatter("getDriverVersion()", metaData.getDriverVersion());
	    addToFormatter("getExtraNameCharacters()", metaData.getExtraNameCharacters());
	    addToFormatter("getIdentifierQuoteString()", metaData.getIdentifierQuoteString());
	    addToFormatter("getJDBCMajorVersion()", metaData.getJDBCMajorVersion());
	    addToFormatter("getJDBCMinorVersion()", metaData.getJDBCMinorVersion());
	    addToFormatter("getMaxBinaryLiteralLength()", metaData.getMaxBinaryLiteralLength());
	    addToFormatter("getMaxCatalogNameLength()", metaData.getMaxCatalogNameLength());
	    addToFormatter("getMaxCharLiteralLength()", metaData.getMaxCharLiteralLength());
	    addToFormatter("getMaxColumnNameLength()", metaData.getMaxColumnNameLength());
	    addToFormatter("getMaxColumnsInGroupBy()", metaData.getMaxColumnsInGroupBy());
	    addToFormatter("getMaxColumnsInIndex()", metaData.getMaxColumnsInIndex());
	    addToFormatter("getMaxColumnsInOrderBy()", metaData.getMaxColumnsInOrderBy());
	    addToFormatter("getMaxColumnsInSelect()", metaData.getMaxColumnsInSelect());
	    addToFormatter("getMaxColumnsInTable()", metaData.getMaxColumnsInTable());
	    addToFormatter("getMaxConnections()", metaData.getMaxConnections());
	    addToFormatter("getMaxCursorNameLength()", metaData.getMaxCursorNameLength());
	    addToFormatter("getMaxIndexLength()", metaData.getMaxIndexLength());
	    addToFormatter("getMaxProcedureNameLength()", metaData.getMaxProcedureNameLength());
	    addToFormatter("getMaxRowSize()", metaData.getMaxRowSize());
	    addToFormatter("getMaxSchemaNameLength()", metaData.getMaxSchemaNameLength());
	    addToFormatter("getMaxStatementLength()", metaData.getMaxStatementLength());
	    addToFormatter("getMaxStatements()", metaData.getMaxStatements());
	    addToFormatter("getMaxTableNameLength()", metaData.getMaxTableNameLength());
	    addToFormatter("getMaxTablesInSelect()", metaData.getMaxTablesInSelect());
	    addToFormatter("getMaxUserNameLength()", metaData.getMaxUserNameLength());
	    addToFormatter("getNumericFunctions()", metaData.getNumericFunctions());
	    addToFormatter("getProcedureTerm()", metaData.getProcedureTerm());
	    addToFormatter("getResultSetHoldability()", metaData.getResultSetHoldability());
	    addToFormatter("getSchemaTerm()", metaData.getSchemaTerm());
	    addToFormatter("getSearchStringEscape()", metaData.getSearchStringEscape());
	    addToFormatter("getSQLKeywords()", metaData.getSQLKeywords());
	    addToFormatter("getSQLStateType()", metaData.getSQLStateType());
	    addToFormatter("getStringFunctions()", metaData.getStringFunctions());
	    addToFormatter("getSystemFunctions()", metaData.getSystemFunctions());
	    addToFormatter("getTimeDateFunctions()", metaData.getTimeDateFunctions());
	    addToFormatter("getURL()", metaData.getURL());
	    addToFormatter("getUserName()", metaData.getUserName());
	    addToFormatter("isCatalogAtStart()", metaData.isCatalogAtStart());
	    addToFormatter("isReadOnly()", metaData.isReadOnly());
	    addToFormatter("locatorsUpdateCopy()", metaData.locatorsUpdateCopy());
	    addToFormatter("nullPlusNonNullIsNull()", metaData.nullPlusNonNullIsNull());
	    addToFormatter("nullsAreSortedAtEnd()", metaData.nullsAreSortedAtEnd());
	    addToFormatter("nullsAreSortedAtStart()", metaData.nullsAreSortedAtStart());
	    addToFormatter("nullsAreSortedHigh()", metaData.nullsAreSortedHigh());
	    addToFormatter("nullsAreSortedLow()", metaData.nullsAreSortedLow());
	    addToFormatter("storesLowerCaseIdentifiers()", metaData.storesLowerCaseIdentifiers());
	    addToFormatter("storesLowerCaseQuotedIdentifiers()", metaData.storesLowerCaseQuotedIdentifiers());
	    addToFormatter("storesMixedCaseIdentifiers()", metaData.storesMixedCaseIdentifiers());
	    addToFormatter("storesMixedCaseQuotedIdentifiers()", metaData.storesMixedCaseQuotedIdentifiers());
	    addToFormatter("storesUpperCaseIdentifiers()", metaData.storesUpperCaseIdentifiers());
	    addToFormatter("storesUpperCaseQuotedIdentifiers()", metaData.storesUpperCaseQuotedIdentifiers());
	    System.out.println(FORMATTER);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    private static void addToFormatter(String methodName, Integer result) {
	FORMATTER.format(FORMAT, COUNTER++, methodName, result);
    }

    private static void addToFormatter(String methodName, Boolean result) {
	FORMATTER.format(FORMAT, COUNTER++, methodName, result);
    }

    private static void addToFormatter(String methodName, String result) {
	FORMATTER.format(FORMAT, COUNTER++, methodName, result);
    }

}
