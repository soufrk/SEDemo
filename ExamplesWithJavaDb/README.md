# ExamplesWithJavaDb - All examples are based on working with JavaDB as choice of database.

Selective areas of JDBC topics of Java 7 for 1Z0-804.

* Precusor
   1. Add 'derby.jar' to project buildpath. This is required by java code to load driver class.
   1. Add 'DERBY_HOME' to path of OS, which should point to <JDK_DIR>/db. 
   1. Test for successful invocation of 'ij' tool that is already provided along with JavaDb. (Will be required for creation of table for the first time.)
   1. Navigate classpath location of project.
   1. Create database
      * Use 'main1' method to create the database using Java-code, OR
	  * Use 'ij' tool to create the database. 
    
* ResultSet
   * Update an existing row.
   * Insert a new row.
