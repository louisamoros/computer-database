package com.louisamoros.cdb.dao.util;

/**
 * The Class QueryStatementGenerator.
 */
public class QueryGenerator {

  private static StringBuilder query;

  /**
   * Instantiates a new query statement generator.
   *
   * @param builder the builder
   */
  private QueryGenerator(Builder builder) {
    query = builder.query;
  }

  public StringBuilder getQuery() {
    return query;
  }

  /**
   * The Class Builder.
   */
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

    private StringBuilder query = new StringBuilder();

    /**
     * Select.
     *
     * @param select the select
     * @return the builder
     */
    public Builder select(String select) {
      query.append(SELECT).append(select);
      return this;
    }

    /**
     * Select count from.
     *
     * @param selectCountFrom the select count from
     * @return the builder
     */
    public Builder selectCountFrom(String selectCountFrom) {
      query.append(SELECT_COUNT_FROM).append(selectCountFrom);
      return this;
    }

    /**
     * From.
     *
     * @param from the from
     * @return the builder
     */
    public Builder from(String from) {
      query.append(FROM).append(from);
      return this;
    }

    /**
     * Left join on.
     *
     * @param leftJoin the left join
     * @param on the on
     * @return the builder
     */
    public Builder leftJoinOn(String leftJoin, String on) {
      query.append(LEFT_JOIN).append(leftJoin).append(ON).append(on);
      return this;
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the builder
     */
    public Builder limit(String limit) {
      query.append(LIMIT).append(limit);
      return this;
    }

    /**
     * Offset.
     *
     * @param offset the offset
     * @return the builder
     */
    public Builder offset(String offset) {
      query.append(OFFSET).append(offset);
      return this;
    }

    /**
     * Where.
     *
     * @param where the where
     * @param whereValue the where value
     * @return the builder
     */
    public Builder where(String where) {
      query.append(WHERE).append(where);
      return this;
    }

    /**
     * Order by.
     *
     * @param orderBy the order by
     * @return the builder
     */
    public Builder orderBy(String orderBy) {
      query.append(ORDER_BY).append(orderBy);
      return this;
    }

    /**
     * Order.
     *
     * @param order the order
     * @return the builder
     */
    public Builder order(String order) {
      query.append(" " + order);
      return this;
    }

    /**
     * Delete from.
     *
     * @param deleteFrom the delete from
     * @return the builder
     */
    public Builder deleteFrom(String deleteFrom) {
      query.append(DELETE_FROM).append(deleteFrom);
      return this;
    }

    /**
     * Update.
     *
     * @param update the update
     * @param set the set
     * @param values the values
     * @return the builder
     */
    public Builder update(String update, String set) {
      query.append(UPDATE).append(update).append(SET).append(set);
      return this;
    }

    /**
     * Insert into.
     *
     * @param insertInto the insert into
     * @param set the set
     * @return the builder
     */
    public Builder insertInto(String insertInto, String set) {
      query.append(INSERT_INTO).append(insertInto).append(VALUES).append(set);
      return this;
    }

    /**
     * Builds the.
     *
     * @return the query statement generator
     */
    public QueryGenerator build() {
      return new QueryGenerator(this);
    }

  }

}
