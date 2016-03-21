<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="global/head.jsp"/>
    <title>Login</title>
</head>
<body>

<jsp:include page="global/header-navbar.jsp"/>

<div class="container" style="max-width:350px">
    <form action="login" method="post">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Invalid username and password.</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <div class="input-group form-group">
            <label class="input-group-addon" for="username">
                <span class="glyphicon glyphicon-user"></span>
            </label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username..." required>
        </div>
        <div class="input-group form-group">
            <label class="input-group-addon" for="password">
                <span class="glyphicon glyphicon-lock"></span>
            </label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password..." required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-block btn-primary">Log in</button>
    </form>
</div>

<jsp:include page="global/footer.jsp" />

</body>
</html>
