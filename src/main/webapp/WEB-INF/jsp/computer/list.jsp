<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Base url -->
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="resources/css/font-awesome.css" rel="stylesheet" media="screen">
<link href="resources/css/main.css" rel="stylesheet" media="screen">
</head>
<body>
 <header class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
   <a class="navbar-brand" href="computer/list"> Application - Computer Database </a>
  </div>
 </header>

 <section id="main">
  <div class="container">
   <h1 id="homeTitle">
    <c:out value="${pageDto.count}"></c:out>
    Computers found
   </h1>
   <div id="actions" class="form-horizontal">
    <div class="pull-left">
     <form id="searchForm" action="computer/list" method="GET" class="form-inline">
      <input type="search" id="searchbox" name="search" value="${pageDto.search}" class="form-control" placeholder="Search name"></input>
      <input type="submit" id="searchsubmit" value="Filter by name" class="btn btn-primary"></input>
     </form>
    </div>
    <div class="pull-right">
     <a class="btn btn-success" id="addComputer" href="computer/new"> AddComputer </a> <a class="btn btn-default" id="editComputer" onclick="$.fn.toggleEditMode();"> Edit </a>
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
      <th class="editMode" style="width: 60px; height: 22px;"><input type="checkbox" id="selectall" /> <span style="vertical-align: top;"> - <a id="deleteSelected" onclick="$.fn.deleteSelected();"> <i class="fa fa-trash-o fa-lg"></i>
       </a>
      </span></th>
      <th><c:choose>
        <c:when test="${pageDto.order == 'asc'}">
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.name" ovr_order="desc"></cdb:link>"> Computer name <span class="glyphicon glyphicon-chevron-down"></span>
         </a>
        </c:when>
        <c:otherwise>
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.name" ovr_order="asc"></cdb:link>"> Computer name <span class="glyphicon glyphicon-chevron-up"></span>
         </a>
        </c:otherwise>
       </c:choose></th>
      <th><c:choose>
        <c:when test="${pageDto.order == 'asc'}">
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.introduced" ovr_order="desc"></cdb:link>"> Introduced date <span class="glyphicon glyphicon-chevron-down"></span>
         </a>
        </c:when>
        <c:otherwise>
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.introduced" ovr_order="asc"></cdb:link>"> Introduced date <span class="glyphicon glyphicon-chevron-up"></span>
         </a>
        </c:otherwise>
       </c:choose></th>
      <th><c:choose>
        <c:when test="${pageDto.order == 'asc'}">
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.discontinued" ovr_order="desc"></cdb:link>"> Discontinued date <span class="glyphicon glyphicon-chevron-down"></span>
         </a>
        </c:when>
        <c:otherwise>
         <a href="<cdb:link page="${pageDto}" ovr_by="computer.discontinued" ovr_order="asc"></cdb:link>"> Discontinued date <span class="glyphicon glyphicon-chevron-up"></span>
         </a>
        </c:otherwise>
       </c:choose></th>
      <th><c:choose>
        <c:when test="${pageDto.order == 'asc'}">
         <a href="<cdb:link page="${pageDto}" ovr_by="company.name" ovr_order="desc"></cdb:link>"> Company <span class="glyphicon glyphicon-chevron-down"></span>
         </a>
        </c:when>
        <c:otherwise>
         <a href="<cdb:link page="${pageDto}" ovr_by="company.name" ovr_order="asc"></cdb:link>"> Company <span class="glyphicon glyphicon-chevron-up"></span>
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
       <td><a href="computer/edit/${computerDto.computerId}"> <c:out value="${computerDto.computerName}" />
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
   <cdb:pagination page="${pageDto}"></cdb:pagination>
  </div>
 </footer>
 <script src="resources/js/jquery.min.js"></script>
 <script src="resources/js/bootstrap.min.js"></script>
 <script src="resources/js/computer.js"></script>
</body>
</html>