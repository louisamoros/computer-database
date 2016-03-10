package com.louisamoros.cdb.dto;

/**
 * The Class PageDto.
 */
public final class PageDto {

    private int page = 0;
    private int perPage = 10;
    private int offset = 0;
    private int limit = 10;
    private int count = 0;
    private String uri = "";
    private int startingPage;
    private int endingPage;
    private int totalPage;
    private String search;
    private String orderBy;
    private String order;

    /**
     * PageDto class uses builder pattern.
     *
     * @param builder the builder
     */
    private PageDto(final Builder builder) {
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.count = builder.count;
        this.uri = builder.uri;
        this.startingPage = builder.startingPage;
        this.endingPage = builder.endingPage;
        this.totalPage = builder.totalPage;
        this.search = builder.search;
        this.orderBy = builder.orderBy;
        this.order = builder.order;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getCount() {
        return count;
    }

    public String getUri() {
        return uri;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public int getEndingPage() {
        return endingPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public String getSearch() {
        return search;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getOrder() {
        return order;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        result = prime * result + endingPage;
        result = prime * result + limit;
        result = prime * result + offset;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((orderBy == null) ? 0 : orderBy.hashCode());
        result = prime * result + page;
        result = prime * result + perPage;
        result = prime * result + ((search == null) ? 0 : search.hashCode());
        result = prime * result + startingPage;
        result = prime * result + totalPage;
        result = prime * result + ((uri == null) ? 0 : uri.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PageDto other = (PageDto) obj;
        if (count != other.count) {
            return false;
        }
        if (endingPage != other.endingPage) {
            return false;
        }
        if (limit != other.limit) {
            return false;
        }
        if (offset != other.offset) {
            return false;
        }
        if (order == null) {
            if (other.order != null) {
                return false;
            }
        } else if (!order.equals(other.order)) {
            return false;
        }
        if (orderBy == null) {
            if (other.orderBy != null) {
                return false;
            }
        } else if (!orderBy.equals(other.orderBy)) {
            return false;
        }
        if (page != other.page) {
            return false;
        }
        if (perPage != other.perPage) {
            return false;
        }
        if (search == null) {
            if (other.search != null) {
                return false;
            }
        } else if (!search.equals(other.search)) {
            return false;
        }
        if (startingPage != other.startingPage) {
            return false;
        }
        if (totalPage != other.totalPage) {
            return false;
        }
        if (uri == null) {
            if (other.uri != null) {
                return false;
            }
        } else if (!uri.equals(other.uri)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PageDto [page=" + page + ", perPage=" + perPage + ", offset=" + offset + ", limit="
                + limit + ", count=" + count + ", uri=" + uri + ", startingPage=" + startingPage
                + ", endingPage=" + endingPage + ", totalPage=" + totalPage + ", search=" + search
                + ", orderBy=" + orderBy + ", order=" + order + "]";
    }

    /**
     * The Class Builder.
     */
    public static class Builder {

        // optional
        private int page;
        private int perPage;
        private int offset;
        private int limit;
        private int count;
        private String uri;
        private int startingPage;
        private int endingPage;
        private int totalPage;
        private String search;
        private String orderBy;
        private String order;

        /**
         * Building the uri.
         *
         * @param uri the uri
         * @return builder
         */
        public final Builder uri(final String uri) {
            this.uri = uri;
            return this;
        }

        /**
         * Building the page number.
         *
         * @param page the page
         * @return builder
         */
        public final Builder page(final int page) {
            this.page = page;
            return this;
        }

        /**
         * Building the per page number.
         *
         * @param perPage the per page
         * @return builder
         */
        public final Builder perPage(final int perPage) {
            this.perPage = perPage;
            return this;
        }

        /**
         * Building the limit.
         *
         * @param limit the limit
         * @return builder
         */
        public final Builder limit(final int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Building the offset.
         *
         * @param offset the offset
         * @return builder
         */
        public final Builder offset(final int offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Building the count of element.
         *
         * @param count the count
         * @return builder
         */
        public final Builder count(final int count) {
            this.count = count;
            return this;
        }

        /**
         * Building the starting page number.
         *
         * @param startingPage the starting page
         * @return builder
         */
        public final Builder startingPage(final int startingPage) {
            this.startingPage = startingPage;
            return this;
        }

        /**
         * Building the ending page number.
         *
         * @param endingPage the ending page
         * @return builder
         */
        public final Builder endingPage(final int endingPage) {
            this.endingPage = endingPage;
            return this;
        }

        /**
         * Building the ending page number.
         *
         * @param totalPage the total number of page
         * @return builder
         */
        public final Builder totalPage(final int totalPage) {
            this.totalPage = totalPage;
            return this;
        }

        /**
         * Building the search.
         *
         * @param search the search
         * @return builder
         */
        public final Builder search(final String search) {
            this.search = search;
            return this;
        }

        /**
         * Building the order by.
         *
         * @param orderBy the order by
         * @return builder
         */
        public final Builder orderBy(final String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Building the order.
         *
         * @param order the order
         * @return builder
         */
        public final Builder order(final String order) {
            this.order = order;
            return this;
        }

        /**
         * Building the page dto object.
         * @return page dto
         */
        public final PageDto build() {
            return new PageDto(this);
        }

    }

}
