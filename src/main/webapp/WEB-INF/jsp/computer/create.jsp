<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../global/head.jsp"></jsp:include>
</head>
<body>

 <jsp:include page="../global/header-navbar.jsp"></jsp:include>
 <spring:message code="label.addComputerButton" var="addComputerButton"></spring:message>

 <section id="main">
  <div class="container">
   <div class="row">
    <div class="col-xs-8 col-xs-offset-2 box">
     <h1>
      <spring:message code="label.addComputerTitle"></spring:message>
     </h1>
     <form:form action="computer/new" method="POST" modelAttribute="computerDto" name="computerDto">
      <fieldset>
       <div class="form-group">
        <form:label for="computerName" path="computerName">
         <spring:message code="label.computerNameLabel"></spring:message>
        </form:label>
        <form:input type="text" class="form-control" id="computerName" name="computerName" placeholder="Computer name" path="computerName" />
        <form:errors path="computerName" class="error" />
       </div>
       <div class="form-group">
        <form:label for="introduced" path="introduced">
         <spring:message code="label.computerIntroducedLabel"></spring:message>
        </form:label>
        <form:input type="date" class="form-control" id="introduced" name="introduced" placeholder="Introduced date" path="introduced" />
        <form:errors path="introduced" class="error" />
       </div>
       <div class="form-group">
        <form:label for="discontinued" path="discontinued">
         <spring:message code="label.computerDiscontinuedLabel"></spring:message>
        </form:label>
        <form:input type="date" class="form-control" id="discontinued" name="discontinued" placeholder="Discontinued date" path="discontinued" />
        <form:errors path="discontinued" class="error" />
       </div>
       <div class="form-group">
        <form:label for="companyId" path="companyId">
         <spring:message code="label.computerCompanyLabel"></spring:message>
        </form:label>
        <form:select class="form-control" id="companyId" name="companyId" path="companyId">
         <option value="0">--
          <spring:message code="label.select"></spring:message> --
         </option>
         <c:forEach items="${companiesDto}" var="companyDto">
          <option value="${companyDto.id}">${companyDto.name}</option>
         </c:forEach>
        </form:select>
       </div>
      </fieldset>
      <div class="actions pull-right">
       <input type="submit" value="${addComputerButton}" class="btn btn-primary">
       or
       <a href="computer/list"><spring:message code="label.cancelLink"></spring:message></a>
      </div>
     </form:form>
    </div>
   </div>
  </div>
 </section>
</body>

<jsp:include page="../global/footer.jsp"></jsp:include>

</html>