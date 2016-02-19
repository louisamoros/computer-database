/*
 * 
 */
package com.louisamoros.cdb.dto;

/**
 * The Class PageDto.
 */
public class PageDto {

	/** The page. */
	private int page = 0;
	
	/** The per page. */
	private int perPage = 10;
	
	/** The offset. */
	private int offset = 0;
	
	/** The limit. */
	private int limit = 10;
	
	/** The count. */
	private int count = 0;
	
	/** The uri. */
	private String uri = "";
	
	/** The starting page. */
	private int startingPage;
	
	/** The ending page. */
	private int endingPage;
	
	/** The total page. */
	private int totalPage;
		
	/**
	 * Instantiates a new page dto.
	 *
	 * @param builder the builder
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + endingPage;
		result = prime * result + limit;
		result = prime * result + offset;
		result = prime * result + page;
		result = prime * result + perPage;
		result = prime * result + startingPage;
		result = prime * result + totalPage;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageDto other = (PageDto) obj;
		if (count != other.count)
			return false;
		if (endingPage != other.endingPage)
			return false;
		if (limit != other.limit)
			return false;
		if (offset != other.offset)
			return false;
		if (page != other.page)
			return false;
		if (perPage != other.perPage)
			return false;
		if (startingPage != other.startingPage)
			return false;
		if (totalPage != other.totalPage)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PageDto [page=" + page + ", perPage=" + perPage + ", offset=" + offset + ", limit=" + limit + ", count="
				+ count + ", uri=" + uri + ", startingPage=" + startingPage + ", endingPage=" + endingPage
				+ ", totalPage=" + totalPage + "]";
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {

		/** The page. */
		// optional
		private int page;
		
		/** The per page. */
		private int perPage;
		
		/** The offset. */
		private int offset;
		
		/** The limit. */
		private int limit;
		
		/** The count. */
		private int count;
		
		/** The uri. */
		private String uri;
		
		/** The starting page. */
		private int startingPage;
		
		/** The ending page. */
		private int endingPage;
		
		/** The total page. */
		private int totalPage;
		
		/**
		 * Uri.
		 *
		 * @param uri the uri
		 * @return the builder
		 */
		public Builder uri(String uri) {
			this.uri = uri;
			return this;
		}
			
		/**
		 * Page.
		 *
		 * @param page the page
		 * @return the builder
		 */
		public Builder page(int page) {
			this.page = page;
			return this;
		}

		/**
		 * Per page.
		 *
		 * @param perPage the per page
		 * @return the builder
		 */
		public Builder perPage(int perPage) {
			this.perPage = perPage;
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
		 * Count.
		 *
		 * @param count the count
		 * @return the builder
		 */
		public Builder count(int count) {
			this.count = count;
			return this;
		}
		
		/**
		 * Starting page.
		 *
		 * @param startingPage the starting page
		 * @return the builder
		 */
		public Builder startingPage(int startingPage) {
			this.startingPage = startingPage;
			return this;
		}
		
		/**
		 * Ending page.
		 *
		 * @param endingPage the ending page
		 * @return the builder
		 */
		public Builder endingPage(int endingPage) {
			this.endingPage = endingPage;
			return this;
		}
				
		/**
		 * Total page.
		 *
		 * @param totalPage the total page
		 * @return the builder
		 */
		public Builder totalPage(int totalPage) {
			this.totalPage = totalPage;
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the page dto
		 */
		public PageDto build() {
			return new PageDto(this);
		}

	}

}
