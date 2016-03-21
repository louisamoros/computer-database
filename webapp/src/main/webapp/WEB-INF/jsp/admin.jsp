<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="global/head.jsp"/>
    <title>Admin</title>
</head>
<body>
<div class="container">
    <div class="alert alert-success">
        Dear <strong>${user}</strong>, Welcome to Admin Page.
        <a href="logout">Logout</a>
    </div>
</div>
</body>
</html>
