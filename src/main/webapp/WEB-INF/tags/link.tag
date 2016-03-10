<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="page" type="com.louisamoros.cdb.dto.PageDto" required="true" description="Page informations"%>
<%@ attribute name="ovr_uri" description="URI of the page to go"%>
<%@ attribute name="ovr_page" description="Page number to use"%>
<%@ attribute name="ovr_order" description="Order to use"%>
<%@ attribute name="ovr_orderBy" description="Order to use"%>
<%@ attribute name="ovr_perPage" description="Order to use"%>

<c:choose>
 <c:when test="${not empty ovr_uri}">
  <c:out value="${ovr_uri}"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.uri}">
   <c:out value="${page.uri}"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
<c:out value="?"></c:out>
<c:choose>
 <c:when test="${not empty ovr_page}">
  <c:out value="p=${ovr_page}&"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.page}">
   <c:out value="p=${page.page}&"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_perPage}">
  <c:out value="pp=${ovr_perPage}&"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.perPage}">
   <c:out value="pp=${page.perPage}&"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_order}">
  <c:out value="order=${ovr_order}&"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.order}">
   <c:out value="order=${page.order}&"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_orderBy}">
  <c:out value="orderby=${ovr_orderBy}&"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.orderBy}">
   <c:out value="orderby=${page.orderBy}&"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_search}">
  <c:out value="s=${ovr_search}&"></c:out>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.search}">
   <c:out value="s=${page.search}&"></c:out>
  </c:if>
 </c:otherwise>
</c:choose>
