package com.louisamoros.cdb.dto;

/**
 * The Class PageDto.
 */
public final class PageDto {

    private int page;
    private int size;
    private int count;
    private int startingPage;
    private int endingPage;
    private int totalPage;
    private String uri;
    private String search;
    private String by;
    private String order;

    private static final int MAX_TO_SHOW = 5;

    /**
     * Page dto class uses builder pattern.
     *
     * @param builder the builder
     */
    private PageDto(final Builder builder) {
        this.page = builder.page;
        this.size = builder.size;
        this.count = builder.count;
        this.startingPage = builder.startingPage;
        this.endingPage = builder.endingPage;
        this.totalPage = builder.totalPage;
        this.uri = builder.uri;
        this.search = builder.search;
        this.by = builder.by;
        this.order = builder.order;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
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

    public String getUri() {
        return uri;
    }

    public String getSearch() {
        return search;
    }

    public String getBy() {
        return by;
    }

    public String getOrder() {
        return order;
    }

    public static int getMaxToShow() {
        return MAX_TO_SHOW;
    }

    /**
     * The builder class for page dto.
     */
    public static class Builder {

        private int page;
        private int size;
        private int count;
        private int startingPage;
        private int endingPage;
        private int totalPage;
        private String uri;
        private String search;
        private String by;
        private String order;

        /**
         * Building the page.
         *
         * @param page the page
         * @return builder
         */
        public final Builder page(final int page) {
            this.page = page;
            return this;
        }

        /**
         * Building the size.
         *
         * @param size the size
         * @return builder
         */
        public final Builder size(final int size) {
            this.size = size;
            return this;
        }

        /**
         * Building the count.
         *
         * @param count the count
         * @return builder
         */
        public final Builder count(final int count) {
            this.count = count;
            return this;
        }

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
         * Building the by.
         *
         * @param by the by
         * @return builder
         */
        public final Builder by(final String by) {
            this.by = by;
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
         * Paginate to build starting, ending and total page.
         *
         * @return builder
         */
        public final Builder paginate() {
            this.totalPage = Math.abs(count / size);
            this.startingPage = Math.max(page - MAX_TO_SHOW / 2, 1);
            this.endingPage = startingPage + MAX_TO_SHOW;
            if (endingPage > totalPage + 1) {
                int diff = endingPage - totalPage;
                startingPage -= diff - 1;
                if (startingPage < 1) {
                    startingPage = 1;
                }
                endingPage = totalPage + 1;
            }
            return this;
        }

        /**
        * Building the page dto object.
        *
        * @return page dto
        */
        public final PageDto build() {
            return new PageDto(this);
        }
    }

}
