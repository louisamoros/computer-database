package com.louisamoros.cdb.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * The Class PageDto.
 */
public class PageDto {

	/** The page. */
	@Min(value=0, message="Invalid page number.")
	private int page = 0;
	
	/** The per page. */
	@Pattern(regexp="((?:1|5|10)0)", message="Invalid per page number.") // authorize 10, 50 ou 100
	private int perPage = 10;
	
	/** The offset. */
	@Min(value=0, message="Invalid offset number.")
	private int offset = 0;
	
	/** The limit. */
	@Min(value=0, message="Invalid limit number.")
	private int limit = 10;
	
	/** The count. */
	@Min(value=0, message="Invalid count number.")
	private int count = 0;

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
	}

	public int getPage() {
		return page;
	}

	public int getPerPage() {
		return perPage;
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	public int count() {
		return count;
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
		 * Builds the.
		 *
		 * @return the page dto
		 */
		public PageDto build() {
			return new PageDto(this);
		}

	}

}
