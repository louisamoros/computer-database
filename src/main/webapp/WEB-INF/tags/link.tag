<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="page" type="com.louisamoros.cdb.dto.PageDto" required="true" description="Page informations" %>
<%@ attribute name="ovr_uri" description="URI of the page to go" %>
<%@ attribute name="ovr_page" description="Page number to use" %>
<%@ attribute name="ovr_order" description="Order to use" %>
<%@ attribute name="ovr_orderBy" description="Order to use" %>
<%@ attribute name="ovr_perPage" description="Order to use" %>

<c:choose>
	<c:when test="${not empty ovr_uri}">
		${ovr_uri}
	</c:when>
	<c:otherwise>
		<c:if test="${not empty page.uri}">${page.uri}</c:if>
	</c:otherwise>
</c:choose>
?
<c:choose>
	<c:when test="${not empty ovr_page}">
		p=${ovr_page}&
	</c:when>
	<c:otherwise>
		<c:if test="${not empty page.page}">p=${page.page}&</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${not empty ovr_perPage}">
		pp=${ovr_perPage}&
	</c:when>
	<c:otherwise>
		<c:if test="${not empty page.perPage}">pp=${page.perPage}&</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${not empty ovr_order}">
		order=${ovr_order}&
	</c:when>
	<c:otherwise>
		<c:if test="${not empty page.order}">order=${page.order}&</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${not empty ovr_orderBy}">
		orderby=${ovr_orderBy}&
	</c:when>
	<c:otherwise>
		<c:if test="${not empty page.orderBy}">orderby=${page.orderBy}&</c:if>
	</c:otherwise>
</c:choose>
