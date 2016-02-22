package com.louisamoros.cdb.controller.util;

/**
 * The Class QueryParams.
 */
public class QueryParams {

  private int offset;
  private int limit;
  private String orderBy;
  private String order;
  private String search;

  
  /**
   * Instantiates a new query params.
   *
   * @param builder the builder
   */
  private QueryParams(Builder builder) {
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

  /**
   * The Class Builder.
   */
  public static class Builder {

    private int offset;
    private int limit;
    private String orderBy;
    private String order;
    private String search;

    /**
     * Offset.
     *
     * @param offset the offset
     * @return the builder
     */
    public Builder offset(int offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the builder
     */
    public Builder limit(int limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Order by.
     *
     * @param orderBy the order by
     * @return the builder
     */
    public Builder orderBy(String orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    /**
     * Order.
     *
     * @param order the order
     * @return the builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Search.
     *
     * @param search the search
     * @return the builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Builds the.
     *
     * @return the query params
     */
    public QueryParams build() {
      return new QueryParams(this);
    }
  }

}
