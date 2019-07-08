<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
<title><spring:message code="header.welcome" /></title>
<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>

	<div class="container">
		
    <div class="row">
       <div class="col-10 align-self-start">
            <div class="jumbotron">
              <h1><spring:message code="header.welcome" /></h1>
            </div>
        </div>
        <div class="col-2 align-self-center">
           <a href="${pageContext.request.contextPath}/language/esp.html?locale=es">ES</a>
           <a href="${pageContext.request.contextPath}/language/eng.html?locale=en">EN</a>
        </div>

    </div>

    <div class="row">
      <div class="col">
          <ul class="nav">
            <li class="nav-item">
              <a id="linkPeopleZone" href="" class="nav-link"><spring:message code="link.peopleZone"/></a>
            </li>
            <li class="nav-item">
              <a id="linkFormationZone" href="" class="nav-link"><spring:message code="link.formationZone"/></a>
            </li>
          </ul>

      </div>

     

    </div>

  </div>

</body>
</html>
