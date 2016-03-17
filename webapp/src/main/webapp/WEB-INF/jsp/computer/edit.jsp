<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../global/head.jsp"></jsp:include>
</head>
<body>
  
  <jsp:include page="../global/header-navbar.jsp"></jsp:include>
  
  <spring:message code="label.editComputerButton" var="editComputerButton"></spring:message>
  
 <section id="main">
  <div class="container">
   <div class="row">
    <div class="col-xs-8 col-xs-offset-2 box">
     <div class="label label-default pull-right">id: ${computerDto.computerId}</div>
     <h1><spring:message code="label.editComputerTitle" ></spring:message></h1>

     <form action="computer/edit/${computerDto.computerId}" method="POST">
      <fieldset>
       <input type="text" id="computerId" name="computerId" value="${computerDto.computerId}" hidden="true" />
       <div class="form-group">
        <label for="computerName"><spring:message code="label.computerNameLabel" ></spring:message></label> <input type="text" class="form-control" id="computerName" name="computerName" placeholder="Computer name" value="${computerDto.computerName}">
       </div>
       <div class="form-group">
        <label for="introduced"><spring:message code="label.computerIntroducedLabel" ></spring:message></label> <input type="date" class="form-control" id="introduced" name="introduced" placeholder="Introduced date" value="${computerDto.introduced}">
       </div>
       <div class="form-group">
        <label for="discontinued"><spring:message code="label.computerDiscontinuedLabel" ></spring:message></label> <input type="date" class="form-control" id="discontinued" name="discontinued" placeholder="Discontinued date" value="${computerDto.discontinued}">
       </div>
       <div class="form-group">
        <label for="companyId"><spring:message code="label.computerCompanyLabel"></spring:message></label> <select class="form-control" id="companyId" name="companyId">
         <option value="0">-- <spring:message code="label.select" ></spring:message> --</option>
         <c:forEach items="${companiesDto}" var="companyDto">
          <option value="${companyDto.id}" <c:if test="${companyDto.id == computerDto.companyId}"> selected="selected"</c:if>>${companyDto.name}</option>
         </c:forEach>
        </select>
       </div>
      </fieldset>
      <div class="actions pull-right">
       <input type="submit" value="${editComputerButton}" class="btn btn-primary"> or <a href="computer/list"><spring:message code="label.cancelLink"></spring:message></a>
      </div>
     </form>
    </div>
   </div>
  </div>
 </section>
</body>

<jsp:include page="../global/footer.jsp"></jsp:include>

</html>