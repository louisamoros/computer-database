<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="page" type="com.louisamoros.cdb.dto.PageDto" required="true" description="Page informations"%>

<fmt:formatNumber var="startingPage" value="${(page.number - 5 / 2) > 1 ? (page.number - 5 / 2) : 1}" maxFractionDigits="0" />
<fmt:formatNumber var="endingPage" value="${startingPage + 5}" maxFractionDigits="0" />
<c:if test="${endingPage >= page.totalPages + 1}">
  <c:set var="startingPage" value="${startingPage - (endingPage - page.totalPages) - 1}"/>
  <c:if test="${startingPage < 1}">
    <c:set var="startingPage" value="1" />
  </c:if>
  <c:set var="endingPage" value="${page.totalPages}" />
</c:if>

<div class="btn-group btn-group-sm pull-right" role="group">
    <a href="<cdb:link page="${page}" ovr_page="1" ovr_size="10" />" class="btn btn-default 
		<c:if test="${page.size == '10'}"> active </c:if> "> 10 </a>
    <a href="<cdb:link page="${page}" ovr_page="1" ovr_size="50" />" class="btn btn-default 
		<c:if test="${page.size == '50'}"> active </c:if> "> 50 </a>
    <a href="<cdb:link page="${page}" ovr_page="1" ovr_size="100" />" class="btn btn-default 
		<c:if test="${page.size == '100'}"> active </c:if> "> 100 </a>
</div>

<ul class="pagination">

    <c:choose>
        <c:when test="${page.number > '1'}">
            <li>
                <a aria-label="First" href="<cdb:link page="${page}" ovr_page="1" />">
                    <i class="glyphicon glyphicon-step-backward"></i>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="disabled">
                <a>
                    <i class="glyphicon glyphicon-step-backward"></i>
                </a>
            </li>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${page.number > '1'}">
            <li>
                <a aria-label="Previous" href="<cdb:link page="${page}" ovr_page="${page.number - 1}" />">
                    <i class="glyphicon glyphicon-chevron-left"></i>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="disabled">
                <a aria-label="Previous">
                    <i class="glyphicon glyphicon-chevron-left"></i>
                </a>
            </li>
        </c:otherwise>
    </c:choose>

    <c:forEach begin="${startingPage}" end="${endingPage}" var="value">
        <li <c:if test="${page.number == value}"> class="active" </c:if>>
            <a href="<cdb:link page="${page}" ovr_page="${value}" />"> ${value}</a>
        </li>
    </c:forEach>

    <c:choose>
        <c:when test="${page.number < page.totalPages - 1}">
            <li>
                <a href="<cdb:link page="${page}" ovr_page="${page.number + 1}" />" aria-label="Next">
                    <i class="glyphicon glyphicon-chevron-right"></i>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="disabled">
                <a aria-label="Next">
                    <i class="glyphicon glyphicon-chevron-right"></i>
                </a>
            </li>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${page.number < page.totalPages - 1}">
            <li>
                <a href="<cdb:link page="${page}" ovr_page="${page.totalPages}" />" aria-label="Last">
                    <i class="glyphicon glyphicon-step-forward"></i>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="disabled">
                <a aria-label="Last">
                    <i class="glyphicon glyphicon-step-forward"></i>
                </a>
            </li>
        </c:otherwise>
    </c:choose>

</ul>

