<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Base url -->
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

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
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<h1>Add Computer</h1>
					<form action="computer/new" method="POST">
						<fieldset>
							<div class="form-group">
								<label for="name">Computer name</label> <input
									type="text" class="form-control" id="name" name="name"
									placeholder="Computer name">
							</div>
							<div class="form-group">
								<label for="introducedDate">Introduced date</label> <input
									type="date" class="form-control" id="introduced" name="introduced"
									placeholder="Introduced date">
							</div>
							<div class="form-group">
								<label for="discontinuedDate">Discontinued date</label> <input
									type="date" class="form-control" id="discontinued" name="discontinued"
									placeholder="Discontinued date">
							</div>
							<div class="form-group">
								<label for="companyId">Company</label> <select
									class="form-control" id="companyId" name="companyId">
									<option value="0">-- select --</option>
									<c:forEach items="${companies}" var="company">
										<option value="${company.companyId}">${company.name}</option>
									</c:forEach>
								</select>
							</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="Add" class="btn btn-primary">
							or <a href="computer">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="jumbotron">
				<form action="" method="post" id="register-form"
					novalidate="novalidate">
					<div id="form-content">
						<fieldset>
							<div class="form-group">
								<label for="firstname">First Name</label> <input type="text"
									name="firstname" class="form-control" />
							</div>
							<div class="form-group">
								<label for="lastname">Last Name</label> <input type="text"
									name="lastname" class="form-control" />
							</div>
							<div class="form-group">
								<label for="email">Email</label> <input type="text" name="email"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									name="password" class="form-control" />
							</div>
							<div>
								<input type="submit" value="Register" class="btn btn-primary" />
							</div>
						</fieldset>
					</div>
				</form>
			</div>
	</section>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/computer.js"></script>

</html>