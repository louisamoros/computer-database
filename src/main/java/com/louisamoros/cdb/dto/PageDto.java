package com.louisamoros.cdb.dto;

/**
 * The Class PageDto.
 */
public class PageDto {

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

  private PageDto(Builder builder) {
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
  public boolean equals(Object obj) {
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

    public Builder uri(String uri) {
      this.uri = uri;
      return this;
    }

    public Builder page(int page) {
      this.page = page;
      return this;
    }

    public Builder perPage(int perPage) {
      this.perPage = perPage;
      return this;
    }

    public Builder limit(int limit) {
      this.limit = limit;
      return this;
    }

    public Builder offset(int offset) {
      this.offset = offset;
      return this;
    }

    public Builder count(int count) {
      this.count = count;
      return this;
    }

    public Builder startingPage(int startingPage) {
      this.startingPage = startingPage;
      return this;
    }

    public Builder endingPage(int endingPage) {
      this.endingPage = endingPage;
      return this;
    }

    public Builder totalPage(int totalPage) {
      this.totalPage = totalPage;
      return this;
    }

    public Builder search(String search) {
      this.search = search;
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

    public PageDto build() {
      return new PageDto(this);
    }

  }

}
