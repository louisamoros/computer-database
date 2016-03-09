<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<a class="navbar-brand" href="computer/list"> Application - Computer Database </a>
		</div>
	</header>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<h1>Add Computer</h1>
					<form:form action="api/computer" method="POST" modelAttribute="computerDto" name="computerDto">
						<fieldset>
							<div class="form-group">
								<form:label for="computerName" path="computerName">Computer name</form:label>
								<form:input type="text" class="form-control" id="computerName" name="computerName" placeholder="Computer name" path="computerName" />
								<form:errors path="computerName" class="error" />
							</div>
							<div class="form-group">
								<form:label for="introduced" path="introduced">Introduced date</form:label>
								<form:input type="date" class="form-control" id="introduced" name="introduced" placeholder="Introduced date" path="introduced" />
								<form:errors path="introduced" class="error" />
							</div>
							<div class="form-group">
								<form:label for="discontinued" path="discontinued">Discontinued date</form:label>
								<form:input type="date" class="form-control" id="discontinued" name="discontinued" placeholder="Discontinued date" path="discontinued" />
								<form:errors path="discontinued" class="error" />
							</div>
							<div class="form-group">
								<form:label for="companyId" path="companyId">Company</form:label> 
								<form:select class="form-control" id="companyId" name="companyId" path="companyId">
									<option value="0">-- select --</option>
									<c:forEach items="${companiesDto}" var="companyDto">
										<option value="${companyDto.id}">${companyDto.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="Add" class="btn btn-primary"> or <a href="computer/list">Cancel</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/computer.js"></script>

</html>