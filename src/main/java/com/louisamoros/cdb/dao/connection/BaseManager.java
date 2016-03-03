// package com.louisamoros.cdb.dao.connection;
//
// import org.omg.CORBA.portable.ApplicationException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
//
// import java.sql.Connection;
// import java.sql.SQLException;
//
// import javax.sql.DataSource;
//
// @Component
// public class BaseManager {
//
// @Autowired
// private static DataSource dataSource;
//
// public static DataSource getDataSource() {
// return dataSource;
// }
//
// public static void setDataSource(DataSource dataSource) {
// CtdbManager.dataSource = dataSource;
// }
//
// public BaseManager() {
// }
//
// protected final Connection getConnection() throws ApplicationException {
// try {
// return dataSource.getConnection();
// } catch (SQLException e) {
// throw new ApplicationException("Unable to get connection", e);
// }
// }
// }