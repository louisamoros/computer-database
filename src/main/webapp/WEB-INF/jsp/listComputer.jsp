<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Computer Database</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Base url -->
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/font-awesome.css" rel="stylesheet" media="screen">
    <link href="css/main.css" rel="stylesheet" media="screen">
</head>
<body>
<header class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="computer"> Application - Computer
            Database </a>
    </div>
</header>

<section id="main">
    <div class="container">
        <h1 id="homeTitle"><c:out value="${page.count}"></c:out> Computers found</h1>
        <div id="actions" class="form-horizontal">
            <div class="pull-left">
                <form id="searchForm" action="#" method="GET" class="form-inline">
                    <input type="search" id="searchbox" name="search"
                           class="form-control" placeholder="Search name" disabled/> <input
                        type="submit" id="searchsubmit" value="Filter by name"
                        class="btn btn-primary disabled"/>
                </form>
            </div>
            <div class="pull-right">
                <a class="btn btn-success" id="addComputer" href="computer/new">
                    AddComputer
                </a>
                <a class="btn btn-default" id="editComputer" onclick="$.fn.toggleEditMode();">
                    Edit
                </a>
            </div>
        </div>
    </div>

    <div class="container" style="margin-top: 10px;">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th class="editMode" style="width: 60px; height: 22px;">
                    <input type="checkbox" id="selectall"/>
                    <span style="vertical-align: top;"> -
                        <a href="#" id="deleteSelected" onclick="$.fn.deleteSelected();">
                            <i class="fa fa-trash-o fa-lg"></i>
                        </a>
                    </span>
                </th>
                <th>
                	<c:choose>
                		<c:when test="${page.order == 'asc'}">
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.name" ovr_order="desc"></cdb:link>">
                				Computer name <span class="glyphicon glyphicon-chevron-down"></span>
                			</a>
                		</c:when>
                		<c:otherwise>
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.name" ovr_order="asc"></cdb:link>">
                				Computer name <span class="glyphicon glyphicon-chevron-up"></span>
                			</a>
                		</c:otherwise>
                	</c:choose>
                </th>
                <th>
                	<c:choose>
                		<c:when test="${page.order == 'asc'}">
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.introduced" ovr_order="desc"></cdb:link>">
                				Introduced date <span class="glyphicon glyphicon-chevron-down"></span>
                			</a>
                		</c:when>
                		<c:otherwise>
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.introduced" ovr_order="asc"></cdb:link>">
                				Introduced date <span class="glyphicon glyphicon-chevron-up"></span>
                			</a>
                		</c:otherwise>
                	</c:choose>
				</th>
                <th>
					<c:choose>
                		<c:when test="${page.order == 'asc'}">
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.discontinued" ovr_order="desc"></cdb:link>">
                				Discontinued date <span class="glyphicon glyphicon-chevron-down"></span>
                			</a>
                		</c:when>
                		<c:otherwise>
                			<a href="<cdb:link page="${page}" ovr_orderBy="computer.discontinued" ovr_order="asc"></cdb:link>">
                				Discontinued date <span class="glyphicon glyphicon-chevron-up"></span>
                			</a>
                		</c:otherwise>
                	</c:choose>
				</th>
                <th>
					<c:choose>
                		<c:when test="${page.order == 'asc'}">
                			<a href="<cdb:link page="${page}" ovr_orderBy="company.name" ovr_order="desc"></cdb:link>">
                				Company <span class="glyphicon glyphicon-chevron-down"></span>
                			</a>
                		</c:when>
                		<c:otherwise>
                			<a href="<cdb:link page="${page}" ovr_orderBy="company.name" ovr_order="asc"></cdb:link>">
                				Company <span class="glyphicon glyphicon-chevron-up"></span>
                			</a>
                		</c:otherwise>
                	</c:choose>
				</th>
            </tr>
            </thead>
            <!-- Browse attribute computers -->
            <tbody id="results">
            <c:forEach items="${computers}" var="computer">
                <tr>
                    <td class="editMode">
                        <input type="checkbox" name="cb" class="cb" value="0">
                    </td>
                    <td>
                        <a href="computer/edit?id=${computer.computerId}">
                            <c:out value="${computer.computerName}"/>
                        </a>
                    </td>
                    <td><c:out value="${computer.introduced}"/></td>
                    <td><c:out value="${computer.discontinued}"/></td>
                    <td><c:out value="${computer.companyName}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<footer class="navbar-fixed-bottom">
    <div class="container text-center">
		<cdb:pagination page="${page}"></cdb:pagination>
    </div>
</footer>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/computer.js"></script>
</body>
</html>