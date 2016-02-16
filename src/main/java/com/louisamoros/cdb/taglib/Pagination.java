package com.louisamoros.cdb.taglib;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pagination extends SimpleTagSupport {

	// action to be hit when clicked
	private String uri;
	// offset of pagination
	private int currentPage = 1;
	// total elements to be shown
	private int totalCount;
	// maximum number of pages to be shown in the pagination bar
	private int maxToShow = 10;
	// maximum number of elements to be shown per page
	private int perPage = 10;
	// text to be shown for previous page link
	private String previous = "Previous";
	// text to be shown for next page link
	private String next = "Next";

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
    public void doTag() throws JspException {
        Writer out = getWriter();

        try {
        	
        	out.write("<div class=\"btn-group btn-group-sm pull-right\" role=\"group\" >");
			out.write(constructButtonLink(10, "10"));
			out.write(constructButtonLink(50, "50"));
			out.write(constructButtonLink(100, "100"));            
            out.write("</div>");
        	
            out.write("<nav>");
            out.write("<ul class=\"pagination\">");

            if(perPage == 0) {
            	perPage = 10;
            }
            int totalPages = Math.abs(totalCount / perPage);
            int startingPage = Math.max(currentPage - maxToShow / 2, 1);
            int endingPage = startingPage + maxToShow;
            boolean isLastPage = currentPage == totalPages;
            
            if (endingPage > totalPages + 1) {
                int diff = endingPage - totalPages;
                startingPage -= diff - 1;
                if (startingPage < 1) {
                    startingPage = 1;
                }
                endingPage = totalPages + 1;
            }

            if (currentPage > 1) {
                out.write(constructLink(currentPage - 1, previous, null, false));
            } else {
                out.write(constructLink(1, previous, "disabled", true));
            }

            for (int i = startingPage ; i < endingPage ; i++) {
                if (i == currentPage) {
                    out.write(constructLink(i, String.valueOf(i), "active", true));
                } else {
                    out.write(constructLink(i, String.valueOf(i), null, false));
                }
            }

            if (isLastPage) {
                out.write(constructLink(endingPage, next, "disabled", true));
            } else {
                out.write(constructLink(currentPage + 1, next, null, false));
            }

            out.write("</ul>");
            out.write("</nav>");


        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    }

	private String constructLink(int page, String text, String className, boolean disabled) {
		StringBuilder link = new StringBuilder("<li");
		if (className != null) {
			link.append(" class=\"");
			link.append(className);
			link.append("\"");
		}
		if (disabled)
			link.append(">").append("<a href=\"\">" + text + "</a></li>");
		else
			link.append(">")
					.append("<a href=\"" + uri + "?page=" + page + "&perpage=" + perPage + "\">" + text + "</a></li>");
		return link.toString();
	}

	private String constructButtonLink(int pp, String text) {
		StringBuilder link = new StringBuilder("<a href=\"" + uri + "?page=" + 1 + "&perpage=" + pp + "\" class=\"btn btn-default\">");
		link.append(text);
		link.append("</a>");
		return link.toString();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getMaxToShow() {
		return maxToShow;
	}

	public void setMaxToShow(int maxToShow) {
		this.maxToShow = maxToShow;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {

		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
}