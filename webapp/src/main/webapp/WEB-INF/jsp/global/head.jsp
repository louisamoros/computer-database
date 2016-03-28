<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Computer Database</title>

<!-- Base url -->
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<!-- bower -->
<link rel="stylesheet" href="/bower_components/material-design-lite/material.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!-- cdb -->
<link href="components/css/main.css" rel="stylesheet" media="screen">
