package com.louisamoros.cdb.dao.util;

/**
 * The Class QueryStatementGenerator.
 */
public final class QueryGenerator {

    private static StringBuilder query;

    /**
     * Instantiates a new query statement generator.
     *
     * @param builder the builder
     */
    private QueryGenerator(final Builder builder) {
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
         * Building the select.
         *
         * @param select
         * @return builder
         */
        public final Builder select(final String select) {
            query.append(SELECT).append(select);
            return this;
        }

        /**
         * Building the selectCountFrom.
         *
         * @param selectCountFrom
         * @return builder
         */
        public final Builder selectCountFrom(final String selectCountFrom) {
            query.append(SELECT_COUNT_FROM).append(selectCountFrom);
            return this;
        }

        /**
         * Building the from.
         *
         * @param from
         * @return builder
         */
        public final Builder from(final String from) {
            query.append(FROM).append(from);
            return this;
        }

        /**
         * Building the leftJoin on.
         *
         * @param leftJoin
         * @param on
         * @return builder
         */
        public final Builder leftJoinOn(final String leftJoin, final String on) {
            query.append(LEFT_JOIN).append(leftJoin).append(ON).append(on);
            return this;
        }

        /**
         * Building the limit.
         *
         * @param limit
         * @return builder
         */
        public final Builder limit(final String limit) {
            query.append(LIMIT).append(limit);
            return this;
        }

        /**
         * Building the offset.
         *
         * @param offset
         * @return builder
         */
        public final Builder offset(final String offset) {
            query.append(OFFSET).append(offset);
            return this;
        }

        /**
         * Building the where.
         *
         * @param where
         * @return builder
         */
        public final Builder where(final String where) {
            query.append(WHERE).append(where);
            return this;
        }

        /**
         * Building the orderBy.
         *
         * @param orderBy
         * @return builder
         */
        public final Builder orderBy(final String orderBy) {
            query.append(ORDER_BY).append(orderBy);
            return this;
        }

        /**
         * Building the order.
         *
         * @param order
         * @return builder
         */
        public final Builder order(final String order) {
            query.append(" " + order);
            return this;
        }

        /**
         * Building the deleteFrom
         *
         * @param deleteFrom
         * @return builder
         */
        public final Builder deleteFrom(final String deleteFrom) {
            query.append(DELETE_FROM).append(deleteFrom);
            return this;
        }

        /**
         * Building the update.
         *
         * @param update
         * @param set
         * @return builder
         */
        public final Builder update(final String update, final String set) {
            query.append(UPDATE).append(update).append(SET).append(set);
            return this;
        }

        /**
         * Building the insertInto
         *
         * @param insertInto
         * @param set
         * @return builder
         */
        public final Builder insertInto(final String insertInto, final String set) {
            query.append(INSERT_INTO).append(insertInto).append(VALUES).append(set);
            return this;
        }

        /**
         * Building the query genrator object.
         *
         * @return the query generator
         */
        public final QueryGenerator build() {
            return new QueryGenerator(this);
        }

    }

}
