package com.louisamoros.cdb.util;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JDBCConnectionImpl.class)
public class ConnectionMock {

	private static Logger LOGGER = LoggerFactory.getLogger(ConnectionMock.class);
	private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	private static final String SQL_FILE = "SCHEMA.sql";
	private static final String DATASET_FILE = "dataset.xml";
	
	private static Connection connectionMock;
	private static JDBCConnection jdbcConnectionMock;
	private static JDBCConnection jdcbConnection;
	
	public static void initConnection() throws Exception {
		
		LOGGER.debug("###### Initialize connection...");
		try {
			RunScript.execute(JDBC_URL, USER, PASSWORD, SQL_FILE, Charset.forName("UTF8"), false);
		} catch (SQLException e1) {
			LOGGER.error("Exception running H2 execute...");
			e1.printStackTrace();
		}
		
		LOGGER.debug("###### Initialize mocking...");
		jdbcConnectionMock = PowerMockito.mock(JDBCConnection.class);
		BDDMockito.given(jdcbConnection).willReturn(jdbcConnectionMock);
		
		LOGGER.debug("###### Datasource creation...");
        JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		
		LOGGER.debug("###### Getting connection...");
		try {
			connectionMock = dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.error("###### Connection error...");
			e.printStackTrace();
		}
		
		LOGGER.debug("###### Moking connection...");
		JDBCConnection jdbcConnection = JDBCConnectionImpl.INSTANCE;
		Mockito.when(jdbcConnection.getConnection()).thenReturn(connectionMock);
		
	}
	

	@Before
	public void importDataSet() throws Exception {
		LOGGER.debug("###### Importing data set...");
		IDataSet dataSet = readDataSet();
		if(dataSet == null) {
			LOGGER.error("###### DATASET_FILE cannot be read correctly.");
		}
		cleanlyInsert(dataSet);
	}

	private IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(ConnectionMock.class.getClassLoader().getResourceAsStream(DATASET_FILE));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
	
	@Test
	public void test() {
		Assert.assertTrue(true);
	}
	
}