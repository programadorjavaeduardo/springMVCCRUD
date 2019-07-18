<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.instructorManagement"></spring:message></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/bootstrap.bundle.min.js "></script>

<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var mensajeConfirmacion="${mensajeConfirmacion}"</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>



</head>
<body>



  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actionsInstructor.jsp" ></jsp:include>
   
    <div class="row mt-5">
        <div class="col">
           <h3> <spring:message code="title.instructorManagement"></spring:message></h3>
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
      				<th><spring:message code="instructor.header.name"></spring:message></th>
      				<th><spring:message code="instructor.header.fatherSurname"></spring:message></th>
      				<th><spring:message code="instructor.header.motherSurname"></spring:message></th>
      				<th><spring:message code="instructor.header.telephone"></spring:message> </th>
      				<th><spring:message code="instructor.header.email"></spring:message> </th>
      				<th colspan="2"><spring:message code="instructor.header.actions"></spring:message></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="instructor" items="${instructores}">
              <tr id="tr_${instructor.id_instructor}">
                <td> ${instructor.id_instructor}</td>
                <td> ${instructor.nombre}</td>
                <td> ${instructor.ape_paterno}</td>
                <td> ${instructor.ape_materno}</td>
                <td> ${instructor.telefono}</td>
                <td> ${instructor.email}</td>
                <td> <a onclick="return confirmarBorrarInstructor(${instructor.id_instructor})"><spring:message code="actions.delete"></spring:message></a> </td>
                <td> <a onclick="obtenerInstructor(${instructor.id_instructor})"> <spring:message code="actions.edit"></spring:message></a> </td>
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
            <a id="linkNuevoInstructor" class="nav-link" href=""><spring:message code="actions.newInstructor"></spring:message></a>
          </li>
          <li class="nav-item">
            <a id="linkIndice" class="nav-link" href=""><spring:message code="actions.index"></spring:message></a>
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
