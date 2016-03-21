<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../global/head.jsp" />
</head>

<body>

    <jsp:include page="../global/header-navbar.jsp" />

    <spring:message code="label.searchPlaceholder" var="searchPlaceholder" />
    <spring:message code="label.searchSubmitButton" var="searchSubmitButton" />

    <section id="main">
        <div class="container">
            <h1 id="homeTitle">
                <c:out value="${page.totalElements} " />
                <spring:message code="label.computerCount" />
            </h1>
            <div id="actions" class="form-horizontal">
                <div class="pull-left">
                    <form id="searchForm" action="computer/list" method="GET" class="form-inline">
                        <input type="search" id="searchbox" name="search" value="${page.search}" class="form-control" placeholder="${searchPlaceholder}" />
                        <input type="submit" value="${searchSubmitButton}" id="searchsubmit" class="btn btn-primary" />
                    </form>
                </div>
                <div class="pull-right">
                    <a class="btn btn-success" id="addComputer" href="computer/new">
                        <spring:message code="label.addComputer" />
                    </a>
                    <a class="btn btn-default" id="editComputer" onclick="$.fn.toggleEditMode();">
                        <spring:message code="label.editComputer" />
                    </a>
                </div>
            </div>
        </div>

        <form id="deleteForm" action="computer/delete" method="POST">
            <input type="hidden" name="selection" value="">
        </form>

        <div class="container" style="margin-top: 10px;">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th class="editMode" style="width: 60px; height: 22px;"><input type="checkbox" id="selectall" /> <span style="vertical-align: top;"> - <a id="deleteSelected" onclick="$.fn.deleteSelected();">
                                    <i class="fa fa-trash-o fa-lg"></i>
                                </a>
                        </span></th>
                        <th><c:choose>
                                <c:when test="${page.order == 'asc'}">
                                    <a href="<cdb:link page="${page}" ovr_by="computerName" ovr_order="desc" />">
                                        <span class="glyphicon glyphicon-chevron-down"></span>
                                        <spring:message code="label.computerNameColumn" />
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<cdb:link page="${page}" ovr_by="computerName" ovr_order="asc" />">
                                        <span class="glyphicon glyphicon-chevron-up"></span>
                                        <spring:message code="label.computerNameColumn" />
                                    </a>
                                </c:otherwise>
                            </c:choose></th>
                        <th><c:choose>
                                <c:when test="${page.order == 'asc'}">
                                    <a href="<cdb:link page="${page}" ovr_by="introduced" ovr_order="desc" />">
                                        <span class="glyphicon glyphicon-chevron-down"></span>
                                        <spring:message code="label.introducedDateColumn" />
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<cdb:link page="${page}" ovr_by="introduced" ovr_order="asc" />">
                                        <span class="glyphicon glyphicon-chevron-up"></span>
                                        <spring:message code="label.introducedDateColumn" />
                                    </a>
                                </c:otherwise>
                            </c:choose></th>
                        <th><c:choose>
                                <c:when test="${page.order == 'asc'}">
                                    <a href="<cdb:link page="${page}" ovr_by="discontinued" ovr_order="desc" />">
                                        <span class="glyphicon glyphicon-chevron-down"></span>
                                        <spring:message code="label.discontinuedDateColumn" />
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<cdb:link page="${page}" ovr_by="discontinued" ovr_order="asc" />">
                                        <span class="glyphicon glyphicon-chevron-up"></span>
                                        <spring:message code="label.discontinuedDateColumn" />
                                    </a>
                                </c:otherwise>
                            </c:choose></th>
                        <th><c:choose>
                                <c:when test="${page.order == 'asc'}">
                                    <a href="<cdb:link page="${page}" ovr_by="companyName" ovr_order="desc" />">
                                        <span class="glyphicon glyphicon-chevron-down"></span>
                                        <spring:message code="label.companyNameColumn" />
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<cdb:link page="${page}" ovr_by="companyName" ovr_order="asc" />">
                                        Company <span class="glyphicon glyphicon-chevron-up"></span>
                                    </a>
                                </c:otherwise>
                            </c:choose></th>
                    </tr>
                </thead>
                <!-- Browse attribute computers -->
                <tbody id="results">
                    <c:forEach items="${computersDto}" var="computerDto">
                        <tr>
                            <td class="editMode"><input type="checkbox" name="cb" class="cb" value="${computerDto.computerId}"></td>
                            <td><a href="computer/edit/${computerDto.computerId}">
                                    <c:out value="${computerDto.computerName}" />
                                </a></td>
                            <td><c:out value="${computerDto.introduced}" /></td>
                            <td><c:out value="${computerDto.discontinued}" /></td>
                            <td><c:out value="${computerDto.companyName}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <footer class="navbar-fixed-bottom">
        <div class="container text-center">
            <cdb:pagination page="${page}" />
        </div>
    </footer>

    <jsp:include page="../global/footer.jsp" />

</body>
</html>