<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../global/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../global/header-navbar.jsp"></jsp:include>

 <section id="main">
  <div class="container">
   <div class="row">
    <div class="col-xs-8 col-xs-offset-2 box">
     <h1>Add Computer</h1>
     <form:form action="computer/new" method="POST" modelAttribute="computerDto" name="computerDto">
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

<jsp:include page="../global/footer.jsp"></jsp:include>

</html>