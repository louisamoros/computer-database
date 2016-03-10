<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
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
   <div class="alert alert-danger">
    Error 404: Page not found. Too bad bitch! <br />
    <!-- stacktrace -->
   </div>
  </div>
 </section>

 <script src="resources/js/jquery.min.js"></script>
 <script src="resources/js/bootstrap.min.js"></script>
 <script src="resources/js/dashboard.js"></script>

</body>
</html>