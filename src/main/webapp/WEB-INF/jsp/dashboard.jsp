<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="cdb" uri="/WEB-INF/taglibs/pagination.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/font-awesome.css" rel="stylesheet" media="screen">
<link href="css/main.css" rel="stylesheet" media="screen">
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="dashboard"> Application - Computer
				Database </a>
		</div>
	</header>

	<section id="main">
		<div class="container">
			<h1 id="homeTitle">
				<c:out value="${numberOfComputers}" />
				Computers found
			</h1>
			<div id="actions" class="form-horizontal">
				<div class="pull-left">
					<form id="searchForm" action="#" method="GET" class="form-inline">
						<input type="search" id="searchbox" name="search"
							class="form-control disabled" placeholder="Search name" /> <input
							type="submit" id="searchsubmit" value="Filter by name"
							class="btn btn-primary disabled" />
					</form>
				</div>
				<div class="pull-right">
					<a class="btn btn-success" id="addComputer" href="addComputer">Add
						Computer</a> <a class="btn btn-default disabled" id="editComputer"
						href="" onclick="$.fn.toggleEditMode();">Edit</a>
				</div>
			</div>
		</div>

		<div class="container" style="margin-top: 10px;">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Computer name</th>
						<th>Introduced date</th>
						<th>Discontinued date</th>
						<th>Company</th>
					</tr>
				</thead>
				<!-- Browse attribute computers -->
				<tbody id="results">
					<c:forEach items="${computers}" var="computer">
						<tr>
							<td><c:out value="${computer.name}" /></td>
							<td><c:out value="${computer.introducedDate}" /></td>
							<td><c:out value="${computer.discontinuedDate}" /></td>
							<td><c:out value="${computer.companyName}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</section>

	<footer class="navbar-fixed-bottom">
		<div class="container text-center">
			<cdb:paginate currentPage="${page}" perPage="${perpage}"
				totalCount="${numberOfComputers}" uri="dashboard" next="&raquo;"
				previous="&laquo;" />
		</div>
	</footer>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/dashboard.js"></script>

</body>
</html>