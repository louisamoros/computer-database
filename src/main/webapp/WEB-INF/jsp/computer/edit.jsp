<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
     <div class="label label-default pull-right">id: ${computerDto.computerId}</div>
     <h1>Edit Computer</h1>

     <form action="computer/edit/${computerDto.computerId}" method="POST">
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

<jsp:include page="../global/footer.jsp"></jsp:include>

</html>