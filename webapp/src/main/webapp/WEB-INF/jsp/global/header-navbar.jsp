<%@ taglib tagdir="/WEB-INF/tags" prefix="cdb"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label.lang" var="lang" />
<header class="navbar navbar-inverse navbar-fixed-top">
 <div class="container">
  <a class="navbar-brand" href="computer/list"> Application - Computer Database </a>
  <ul class="nav navbar-nav navbar-right">
   <li class="dropdown">
    <a href="#" class="dropdown-toggle white-color" data-toggle="dropdown" role="button" aria-expanded="false">
     <span class="bfh-languages" data-language="${lang}" data-flags="true"></span> <span class="caret"></span>
    </a>
    <ul class="dropdown-menu" role="menu">
     <li>
      <a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">
       <span class="bfh-languages" data-language="en_US" data-flags="true"></span>
      </a>
     </li>
     <li>
      <a href="${requestScope['javax.servlet.forward.request_uri']}?lang=fr">
       <span class="bfh-languages" data-language="fr_FR" data-flags="true"></span>
      </a>
     </li>
    </ul>
   </li>
  </ul>
 </div>
</header>