package com.louisamoros.cdb.controller;

/**
 * The Params class.
 */
public class Params {

    private int page;
    private int size;
    private String order;
    private String by;
    private String search;

    private int limit;
    private int offset;

    /**
     * Constructor.
     * @param page the page
     * @param size the size
     * @param order the order
     * @param by the by
     * @param search the search
     */
    public Params(final int page, final int size, final String order, final String by,
            final String search) {
        super();
        this.page = page;
        this.size = size;
        this.order = order;
        this.by = by;
        this.search = search;
    }

    public final int getPage() {
        return page;
    }

    public final void setPage(final int page) {
        this.page = page;
    }

    public final int getSize() {
        return size;
    }

    public final void setSize(final int size) {
        this.size = size;
    }

    public final String getOrder() {
        return order;
    }

    public final void setOrder(final String order) {
        this.order = order;
    }

    public final String getBy() {
        return by;
    }

    public final void setBy(final String by) {
        this.by = by;
    }

    public final String getSearch() {
        return search;
    }

    public final void setSearch(final String search) {
        this.search = search;
    }

    public final int getLimit() {
        return limit;
    }

    public final int getOffset() {
        return offset;
    }

    @Override
    public final String toString() {
        return "Params [page=" + page + ", size=" + size + ", order=" + order + ", by=" + by
                + ", search=" + search + "]";
    }

    /**
     * Verification method to make sure parameter are correct.
     */
    public final void verify() {

        if (page < 1) {
            this.page = 1;
        }
        if (size != 50 && size != 100) {
            this.size = 10;
        }
        if (search == null) {
            this.search = "";
        }
        if (!"company.name".equals(by) && !"computer.introduced".equals(by)
                && !"computer.discontinued".equals(by)) {
            this.by = "computer.name";
        }
        if (!"desc".equals(order)) {
            this.order = "asc";
        }
        this.limit = size;
        this.offset = (page - 1) * size;

    }

}
