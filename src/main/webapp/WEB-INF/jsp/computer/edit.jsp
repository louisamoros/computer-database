<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb"%>

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
					<div class="label label-default pull-right">id: ${computerDto.computerId}</div>
					<h1>Edit Computer</h1>

					<form action="api/computer/${computerDto.computerId}" method="POST">
						<fieldset>
							<input type="text" id="computerId" name="computerId" value="${computerDto.computerId}" hidden="true" />
							<div class="form-group">
								<label for="computerName">Computer name</label> <input type="text" class="form-control" id="computerName" name="computerName" placeholder="Computer name" value="${computerDto.computerName}">
							</div>
							<div class="form-group">
								<label for="introduced">Introduced date</label> <input type="date" class="form-control" id="introduced" name="introduced" placeholder="Introduced date" value="${computerDto.introduced}">
							</div>
							<div class="form-group">
								<label for="discontinued">Discontinued date</label> <input type="date" class="form-control" id="discontinued" name="discontinued" placeholder="Discontinued date" value="${computerDto.discontinued}">
							</div>
							<div class="form-group">
								<label for="companyId">Company</label> <select class="form-control" id="companyId" name="companyId">
									<option value="0">-- select --</option>
									<c:forEach items="${companiesDto}" var="companyDto">
										<option value="${companyDto.id}" <c:if test="${companyDto.id == computerDto.companyId}"> selected="selected"</c:if>>${companyDto.name}</option>
									</c:forEach>
								</select>
							</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="Edit" class="btn btn-primary"> or <a href="computer/list">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>