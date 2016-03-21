<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="global/head.jsp"/>
    <title>Denied</title>
</head>
<body>

<jsp:include page="global/header-navbar.jsp"/>

<div class="container">
    <div class="alert alert-success">
        <p>Dear <strong>${user}</strong>, You are not authorized to access this page
            <a href="logout">Logout</a>
        </p>
    </div>
</div>

<jsp:include page="global/footer.jsp" />

</body>
</html>
