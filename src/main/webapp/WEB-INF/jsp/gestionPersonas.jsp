<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
</head>
<body>



  <div class="container">

    <jsp:include page="../../common/header.jsp" />
    <hr>

    <div class="row mb-4">
        <div class="col">
           <h4> Lista de Personas</h4>
        </div>
    </div>
    <div class="row mb-6">
      <div class="col">
        <p id="rojo"> ${mensaje} </p>
      </div>
    </div>

    <div class="row">
      <div class="col">
        <table class="table table-hover table-bordered">
          <thead>
            <tr>
              <th>Id </th>
      				<th>Nombre </th>
      				<th>Apellido Materno</th>
      				<th>Apellido Paterno</th>
      				<th>Telefono </th>
      				<th>Email </th>
      				<th>Formacion Academica </th>
      				<th colspan="2">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="persona" items="${personas}">
              <tr>
                <td> ${persona.id_persona}</td>
                <td> ${persona.nombre}</td>
                <td> ${persona.ape_materno}</td>
                <td> ${persona.ape_paterno}</td>
                <td> ${persona.telefono}</td>
                <td> ${persona.email}</td>
                <td> ${persona.formacion.descripcion}</td>
                <td> <a href="${pageContext.request.contextPath}/person/deletePerson.html?idPersona=${persona.id_persona}" id="enlBorrar" onclick="return confirmarBorrar()">Borrar</a> </td>
                <td> <a href="${pageContext.request.contextPath}/person/getPerson.html?idPersona=${persona.id_persona}">Editar</a> </td>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/person/newPerson.html">Nueva Persona</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/">Ir a Inicio</a>
          </li>
        </ul>

      </div>
    </div>
    <%-- <a href="${pageContext.request.contextPath}/person/downloadPDFFormat.html">Descargar archivo PDF</a>
    <a href="${pageContext.request.contextPath}/person/downloadXLSFormat.html">Descargar archivo XLS</a> --%>


    <jsp:include page="../../common/footer.jsp" />
  </div>

</body>
</html>
