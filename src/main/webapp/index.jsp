<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
<title>Bienvenido</title>
</head>
<body>

	<div class="container">
    <div class="row">
        <div class="col">
            <div class="jumbotron">
              <h1>Bienvenidos a la aplicacion de gestion de personas</h1>
            </div>
        </div>

    </div>
    <div class="row">
      <div class="col">
          <ul class="nav">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/person/gestionPersonas.html" class="nav-link">Acceso a Gestion Personas</a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/formacion/gestionFormaciones.html" class="nav-link">Acceso a Gestion Formaciones</a>
            </li>
          </ul>

      </div>

    </div>

  </div>

</body>
</html>
