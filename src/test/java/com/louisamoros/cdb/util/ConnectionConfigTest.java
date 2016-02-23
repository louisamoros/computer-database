/*
 * package com.louisamoros.cdb.util;
 * 
 * import java.nio.charset.Charset; import java.sql.SQLException; import java.util.Properties;
 * 
 * import org.dbunit.IDatabaseTester; import org.dbunit.JdbcDatabaseTester; import
 * org.dbunit.dataset.IDataSet; import org.dbunit.dataset.xml.FlatXmlDataSetBuilder; import
 * org.dbunit.operation.DatabaseOperation; import org.h2.jdbcx.JdbcDataSource; import
 * org.h2.tools.RunScript; import org.junit.Assert; import org.junit.Before; import
 * org.junit.BeforeClass; import org.junit.Test; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import com.louisamoros.cdb.util.JDBCConnection;
 * 
 * public class ConnectionConfigTest {
 * 
 * private static Logger LOGGER = LoggerFactory.getLogger(ConnectionConfigTest.class); private
 * static final String SQL_FILE = "SCHEMA.sql"; private static final String DATASET_FILE =
 * "dataset.xml"; private static JDBCConnection jdbcConnection; private static JdbcDataSource
 * dataSource; private static Properties properties;
 * 
 * @BeforeClass public static void initConnection() throws Exception {
 * 
 * jdbcConnection = JDBCConnectionImpl.INSTANCE; properties = jdbcConnection.getProperties();
 * LOGGER.debug(properties.getProperty("url")); LOGGER.debug(properties.getProperty("username"));
 * 
 * try { RunScript.execute(properties.getProperty("url"), properties.getProperty("username"),
 * properties.getProperty("password"),
 * ConnectionConfigTest.class.getClassLoader().getResourceAsStream(SQL_FILE).toString(),
 * Charset.forName("UTF8"), false); } catch (SQLException e1) { LOGGER.error(
 * "Exception running H2 execute..."); e1.printStackTrace(); }
 * 
 * dataSource = new JdbcDataSource(); dataSource.setURL(properties.getProperty("url"));
 * dataSource.setUser(properties.getProperty("username"));
 * dataSource.setPassword(properties.getProperty("password"));
 * 
 * }
 * 
 * @Before public void importDataSet() throws Exception { LOGGER.debug(
 * "###### Importing data set..."); IDataSet dataSet = readDataSet(); if (dataSet == null) {
 * LOGGER.error("###### DATASET_FILE cannot be read correctly."); } cleanlyInsert(dataSet); }
 * 
 * private IDataSet readDataSet() throws Exception { return new FlatXmlDataSetBuilder()
 * .build(ConnectionConfigTest.class.getClassLoader().getResourceAsStream(DATASET_FILE)); }
 * 
 * private void cleanlyInsert(IDataSet dataSet) throws Exception { IDatabaseTester databaseTester =
 * new JdbcDatabaseTester(properties.getProperty("driver"), properties.getProperty("url"),
 * properties.getProperty("username"), properties.getProperty("password"));
 * databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
 * databaseTester.setDataSet(dataSet); databaseTester.onSetup(); }
 * 
 * @Test public void test() { Assert.assertTrue(true); }
 * 
 * }
 */