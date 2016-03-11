<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="page" type="com.louisamoros.cdb.dto.PageDto" required="true" description="Page informations"%>
<%@ attribute name="ovr_uri" description="URI of the page to go"%>
<%@ attribute name="ovr_page" description="Page number to use"%>
<%@ attribute name="ovr_order" description="Order to use"%>
<%@ attribute name="ovr_by" description="Order to use"%>
<%@ attribute name="ovr_size" description="Order to use"%>

<c:choose>
 <c:when test="${not empty ovr_uri}">
  <c:set var="url" value="${ovr_uri}" />
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.uri}">
   <c:set var="url" value="${page.uri}" />
  </c:if>
 </c:otherwise>
</c:choose>
<c:set var="url" value="${url}?"></c:set>
<c:choose>
 <c:when test="${not empty ovr_page}">
  <c:set var="url" value="${url}page=${ovr_page}&"></c:set>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.page}">
   <c:set var="url" value="${url}page=${page.page}&"></c:set>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_size}">
  <c:set var="url" value="${url}size=${ovr_size}&"></c:set>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.size}">
   <c:set var="url" value="${url}size=${page.size}&"></c:set>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_order}">
  <c:set var="url" value="${url}order=${ovr_order}&"></c:set>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.order}">
   <c:set var="url" value="${url}order=${page.order}&"></c:set>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_by}">
    <c:set var="url" value="${url}by=${ovr_by}&"></c:set>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.by}">
      <c:set var="url" value="${url}by=${page.by}&"></c:set>
  </c:if>
 </c:otherwise>
</c:choose>
<c:choose>
 <c:when test="${not empty ovr_search}">
    <c:set var="url" value="${url}search=${ovr_search}&"></c:set>
 </c:when>
 <c:otherwise>
  <c:if test="${not empty page.search}">
   <c:set var="url" value="${url}search=${page.search}&"></c:set>
  </c:if>
 </c:otherwise>
</c:choose>
<c:set var="url" value="${fn:substring(url, 0, fn:length(url) -1)}" />
 <c:out value="${url}"></c:out>