package com.louisamoros.cdb.controller.util;

/**
 * POJO used to store query parameters for specific requests.
 */
public final class QueryParams {

    private int offset;
    private int limit;
    private String orderBy;
    private String order;
    private String search;

    /**
     * QueryParams class use builder pattern.
     *
     * @param builder
     */
    private QueryParams(final Builder builder) {
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.order = builder.order;
        this.orderBy = builder.orderBy;
        this.search = builder.search;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getOrder() {
        return order;
    }

    public String getSearch() {
        return search;
    }

    @Override
    public String toString() {
        return "QueryParams [offset=" + offset + ", limit=" + limit + ", orderBy=" + orderBy
                + ", order=" + order + ", search=" + search + "]";
    }

    public static class Builder {

        private int offset;
        private int limit;
        private String orderBy;
        private String order;
        private String search;

        /**
         * Building the offset.
         *
         * @param offset
         * @return builder
         */
        public final Builder offset(final int offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Building the limit.
         *
         * @param limit
         * @return builder
         */
        public final Builder limit(final int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Building the orde by.
         *
         * @param orderBy
         * @return builder
         */
        public final Builder orderBy(final String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Building the order.
         *
         * @param order
         * @return builder
         */
        public final Builder order(final String order) {
            this.order = order;
            return this;
        }

        /**
         * Building the search.
         *
         * @param search
         * @return builder
         */
        public final Builder search(final String search) {
            this.search = search;
            return this;
        }

        /**
         * Building the query params object.
         *
         * @return the query params
         */
        public final QueryParams build() {
            return new QueryParams(this);
        }
    }

}
