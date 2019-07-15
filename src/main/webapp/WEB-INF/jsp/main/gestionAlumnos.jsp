<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.studentManagement"></spring:message></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var mensajeConfirmacion="${mensajeConfirmacion}"</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosAlumno.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>


</head>
<body>



  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actions.jsp" ></jsp:include>
   
    <div class="row mt-5">
        <div class="col">
           <h3> <spring:message code="title.studentManagement"></spring:message></h3>
        </div>
    </div>
    <div class="row">
      <div class="col">
        <p id="rojo"> ${mensaje} </p>
      </div>
    </div>

    <div class="row mt-5">
      <div class="col">
        <table class="table table-hover table_bordered">
          <thead>
            <tr>
              		<th>Id </th>
      				<th><spring:message code="alumno.header.name"></spring:message></th>
      				<th><spring:message code="alumno.header.motherSurname"></spring:message></th>
      				<th><spring:message code="alumno.header.fatherSurname"></spring:message></th>
      				<th><spring:message code="alumno.header.telephone"></spring:message> </th>
      				<th><spring:message code="alumno.header.email"></spring:message> </th>
      				<th><spring:message code="alumno.header.formation"></spring:message></th>
      				<th colspan="2"><spring:message code="alumno.header.actions"></spring:message></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="Alumno" items="${Alumnos}">
              <tr id="tr_${Alumno.id_alumno}">
                <td> ${Alumno.id_alumno}</td>
                <td> ${Alumno.nombre}</td>
                <td> ${Alumno.ape_materno}</td>
                <td> ${Alumno.ape_paterno}</td>
                <td> ${Alumno.telefono}</td>
                <td> ${Alumno.email}</td>
                <td> ${sessionScope['lang']=='es' ? Alumno.formacion.descripcionEsp : Alumno.formacion.descripcionEng} </td>
                <td> <a onclick="return confirmarBorrarAlumno(${Alumno.id_alumno})"><spring:message code="actions.delete"></spring:message></a> </td>
                <td> <a onclick="obtenerAlumno(${Alumno.id_alumno})"> <spring:message code="actions.edit"></spring:message></a> </td>
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
            <a id="linkNewAlumno" class="nav-link" href=""><spring:message code="actions.newAlumno"></spring:message></a>
          </li>
          <li class="nav-item">
            <a id="linkIndex" class="nav-link" href=""><spring:message code="actions.index"></spring:message></a>
          </li>
        </ul>

      </div>
    </div>
    <%-- <a href="${pageContext.request.contextPath}/person/downloadPDFFormat.html">Descargar archivo PDF</a>
    <a href="${pageContext.request.contextPath}/person/downloadXLSFormat.html">Descargar archivo XLS</a> --%>


    <jsp:include page="../common/footer.jsp" />
  </div>

</body>
</html>
