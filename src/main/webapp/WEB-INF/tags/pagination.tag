<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="page" type="com.louisamoros.cdb.dto.PageDto" required="true" description="Page informations" %>

<div class="btn-group btn-group-sm pull-right" role="group">
	<a href="${uri}?p=1&pp=10" class="btn btn-default 
		<c:if test="${page.perPage == '10'}"> active </c:if> "> 10 </a>
	<a href="${uri}?p=1&pp=50" class="btn btn-default 
		<c:if test="${page.perPage == '50'}"> active </c:if> "> 50 </a>
	<a href="${uri}?p=1&pp=100" class="btn btn-default 
		<c:if test="${page.perPage == '100'}"> active </c:if> "> 100 </a>
</div>

<ul class="pagination">

	<c:choose>
		<c:when test="${page.page > '1'}">
			<li><a href="${uri}?p=1&pp=${page.perPage}" aria-label="First">
					<span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled">
			<a href="" aria-label="First">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>			
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${page.page > '1'}">
			<li><a  href="${uri}?p=${page.page - 1}&pp=${page.perPage}" aria-label="Previous">
					<span aria-hidden="true">&lsaquo;</span>
			</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled">
			<a href="" aria-label="Previous">
				<span aria-hidden="true">&lsaquo;</span>
			</a>
		</li>			
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${page.startingPage}" end="${page.endingPage - 1}" var="value">
		<li <c:if test="${page.page == value}"> class="active" </c:if> >
			<a href="${uri}?p=${value}&pp=${page.perPage}"> ${value} </a>
		</li>
	</c:forEach>
	
	<c:choose>
		<c:when test="${page.page != page.totalPage}">
			<li><a href="${uri}?p=${page.page + 1}&pp=${page.perPage}" aria-label="Next">
				<span aria-hidden="true">&rsaquo;</span>
			</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled">
			<a href="" aria-label="Next">
				<span aria-hidden="true">&rsaquo;</span>
			</a>
		</li>			
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${page.page != page.totalPage}">
			<li><a  href="${uri}?p=${page.totalPage}&pp=${page.perPage}" aria-label="Last">
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled">
			<a href="" aria-label="Last">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>			
		</c:otherwise>
	</c:choose>
		
</ul>

