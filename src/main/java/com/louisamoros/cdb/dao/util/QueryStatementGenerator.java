package com.louisamoros.cdb.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dao.exception.DaoException;

public class QueryStatementGenerator {

	private static StringBuilder query;
	private static PreparedStatement preparedStatement;

	private QueryStatementGenerator(Builder builder) {
		query = builder.query;
		preparedStatement = builder.preparedStatement;
	}
	
	public StringBuilder getQuery() {
		return query;
	}
	
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	
	public static class Builder {
		
		private static final String SELECT = " SELECT ";
		private static final String FROM = " FROM ";
		private static final String LEFT_JOIN = " LEFT JOIN ";
		private static final String ON = " ON ";
		private static final String WHERE = " WHERE ";
		private static final String ORDER_BY = " ORDER BY ";
		private static final String LIMIT = " LIMIT ";
		private static final String OFFSET = " OFFSET ";
		private static final String UPDATE = " UPDATE ";
		private static final String SET = " SET ";
		private static final String DELETE_FROM = " DELETE FROM ";
		private static final String SELECT_COUNT_FROM = " SELECT COUNT(*) FROM ";
		private static final String INSERT_INTO = " INSERT INTO ";
		private static final String VALUES = " VALUES ";
		private static List<String> insertIntoPS = new ArrayList<>();
		
		private StringBuilder query = new StringBuilder();
		private PreparedStatement preparedStatement;
		private static Connection conn = null;
		
		public Builder (Connection conn) {
			Builder.conn = conn;
		}
		
		public Builder select(String select) {
			query.append(SELECT).append(select);
			return this;
		}
		
		public Builder selectCountFrom(String selectCountFrom) {
			query.append(SELECT_COUNT_FROM).append(selectCountFrom);
			return this;
		}
		
		public Builder from(String from) {
			query.append(FROM).append(from);
			return this;
		}
		
		public Builder leftJoinOn(String leftJoin, String on) {
			query.append(LEFT_JOIN).append(leftJoin).append(ON).append(on);
			return this;
		}
		
		public Builder limit(String limit) {
			query.append(LIMIT).append(limit);
			return this;
		}
		
		public Builder offset(String offset) {
			query.append(OFFSET).append(offset);
			return this;
		}
		
		public Builder where(String where, String whereValue) {
			query.append(WHERE).append(where);
			insertIntoPS.add(whereValue);
			return this;
		}
		
		public Builder orderBy(String orderBy) {
			query.append(ORDER_BY).append(orderBy);
			return this;
		}
		
		public Builder order(String order) {
			query.append(" " + order);
			return this;
		}
		
		public Builder deleteFrom(String deleteFrom) {
			query.append(DELETE_FROM).append(deleteFrom);
			return this;
		}
		
		public Builder update(String update, String set, List<String> values) {
			query.append(UPDATE).append(update).append(SET).append(set);
			values.forEach(value -> insertIntoPS.add(value));
			return this;
		}
		
		public Builder insertInto(String insertInto, String set, List<String> values) {
			query.append(INSERT_INTO).append(insertInto).append(VALUES).append(set);
			values.forEach(value -> insertIntoPS.add(value));
			return this;
		}
		
		public QueryStatementGenerator build() {
			try {
				preparedStatement = conn.prepareStatement(query.toString());
				for(int i = 1 ; i < insertIntoPS.size() ; i++) {
					preparedStatement.setString(i, insertIntoPS.get(i));
				}
			} catch (SQLException e) {
				throw new DaoException("Fail during: " + query, e);
			} catch (Exception e) {
				throw new DaoException("Fail during: " + query, e);
			}
			return new QueryStatementGenerator(this);
		}
		
	}
	
	
}
