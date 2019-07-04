<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
<title><spring:message code="header.welcome" /></title>
</head>
<body>

	<div class="container">
    <div class="row">
       <div class="col-10">
            <div class="jumbotron">
              <h1><spring:message code="header.welcome" /></h1>
            </div>
        </div>
        <div class="col-2">
           <a href="${pageContext.request.contextPath}?locale=es">ES</a>
           <a href="${pageContext.request.contextPath}?locale=en">EN</a>
        </div>

    </div>
    
    <div class="row">
      <div class="col">
          <ul class="nav">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/person/gestionPersonas.html" class="nav-link"><spring:message code="link.peopleZone"/></a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/formacion/gestionFormaciones.html" class="nav-link"><spring:message code="link.formationZone"/></a>
            </li>
          </ul>

      </div>

    </div>

  </div>

</body>
</html>
