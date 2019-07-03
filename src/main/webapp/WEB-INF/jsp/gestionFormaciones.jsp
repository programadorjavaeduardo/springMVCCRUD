<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
</head>
<body>
  <div class="container">
    <jsp:include page="../../common/header.jsp" />
    <div class="row mt-5">
      <div class="col">
          <h3> Lista de Formaciones</h3>
      </div>
    </div>


    <div class="row">
        <div class="col">
          <p id="rojo"> ${mensaje} </p>
        </div>

    </div>

    <div class="row mt-5">
      <div class="col">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
      				<th>Id </th>
      				<th>Descripcion </th>
      				<th colspan="2">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="formacion" items="${formaciones}">
              <tr>
                <td> ${formacion.id_formacion}</td>
                <td> ${formacion.descripcion}</td>
                <td> <a href="${pageContext.request.contextPath}/formacion/deleteFormacion.html?id_formacion=${formacion.id_formacion}" id="enlBorrar" onclick="return confirmarBorrar()">Borrar</a> </td>
                <td> <a href="${pageContext.request.contextPath}/formacion/getFormacion.html?id_formacion=${formacion.id_formacion}">Editar</a> </td>
              </tr>

            </c:forEach>
          </tbody>
        </table>

      </div>
    </div>

    <div class="row">
      <div class="col">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/formacion/newFormacion.html">Nueva Formacion</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/">Ir a Inicio</a>
          </li>
        </ul>

      </div>
    </div>
      <jsp:include page="../../common/footer.jsp" />
  </div>

</body>
</html>
