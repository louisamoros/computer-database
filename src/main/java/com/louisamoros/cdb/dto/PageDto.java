package com.louisamoros.cdb.dto;

/**
 * Page params which is a wrapper of params attributes and spring page to return to the jsp.
 */
public final class PageDto {

    private int totalPages;
    private long totalElements;
    private int number;
    private int size;
    private String sort;
    private String search;
    private String uri;

    /**
     * Private constructor using builder pattern.
     * @param builder the builder
     */
    private PageDto(final Builder builder) {
        this.totalPages = builder.totalPages;
        this.totalElements = builder.totalElements;
        this.number = builder.number;
        this.size = builder.size;
        this.sort = builder.sort;
        this.search = builder.search;
        this.uri = builder.uri;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public String getSort() {
        return sort;
    }

    public String getSearch() {
        return search;
    }

    public String getUri() {
        return uri;
    }

    /**
     * The builder class.
     */
    public static class Builder {

        private int totalPages;
        private long totalElements;
        private int number;
        private int size;
        private String sort;
        private String search;
        private String uri;

        /**
         * Building the total number of pages.
         * @param totalPages the total of pages
         * @return the builder
         */
        public final Builder totalPages(final int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        /**
         * Building the total number of elements in the page.
         * @param totalElements the total elements
         * @return the builder
         */
        public final Builder totalElements(final long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        /**
         * Building the number of page.
         * @param number the page number
         * @return the builder
         */
        public final Builder number(final int number) {
            this.number = number;
            return this;
        }

        /**
         * Building the size.
         * @param size the size
         * @return the builder
         */
        public final Builder size(final int size) {
            this.size = size;
            return this;
        }

        /**
         * Building the sort.
         * @param sort the sort
         * @return the builder
         */
        public final Builder sort(final String sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Building the search.
         * @param search the search
         * @return the builder
         */
        public final Builder search(final String search) {
            this.search = search;
            return this;
        }

        /**
         * Building the uri.
         * @param uri the uri
         * @return the builder
         */
        public final Builder uri(final String uri) {
            this.uri = uri;
            return this;
        }

        /**
         * Building the page dto.
         * @return the page dto object
         */
        public final PageDto build() {
            return new PageDto(this);
        }
    }
}
