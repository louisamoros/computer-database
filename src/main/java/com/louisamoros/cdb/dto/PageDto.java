package com.louisamoros.cdb.dto;

/**
 * PageDto using Builder static class for constructor.
 *
 * @author louis
 */
public class PageDto {

	private int page = 0;
	private int perPage = 10;
	private int offset = 0;
	private int limit = 10;

	private PageDto(Builder builder) {
		this.page = builder.page;
		this.perPage = builder.perPage;
		this.offset = builder.offset;
		this.limit = builder.limit;
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

	public static class Builder {

		// optional
		private int page;
		private int perPage;
		private int offset;
		private int limit;

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

		public PageDto build() {
			return new PageDto(this);
		}

	}
	
}
