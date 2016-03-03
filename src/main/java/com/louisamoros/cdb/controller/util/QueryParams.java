package com.louisamoros.cdb.controller.util;

public class QueryParams {

  private int offset;
  private int limit;
  private String orderBy;
  private String order;
  private String search;

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

  public static class Builder {

    private int offset;
    private int limit;
    private String orderBy;
    private String order;
    private String search;

    public Builder offset(int offset) {
      this.offset = offset;
      return this;
    }

    public Builder limit(int limit) {
      this.limit = limit;
      return this;
    }

    public Builder orderBy(String orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    public Builder order(String order) {
      this.order = order;
      return this;
    }

    public Builder search(String search) {
      this.search = search;
      return this;
    }

    public QueryParams build() {
      return new QueryParams(this);
    }
  }

}
