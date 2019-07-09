<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.peopleManagement"></spring:message></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var mensajeConfirmacion="${mensajeConfirmacion}"</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
</head>
<body>



  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actions.jsp" ></jsp:include>
    <hr>

    <div class="row mb-4">
        <div class="col">
           <h4> <spring:message code="title.peopleList"></spring:message></h4>
        </div>
    </div>
    <div class="row mb-6">
      <div class="col">
        <p id="rojo"> ${mensaje} </p>
      </div>
    </div>

    <div class="row">
      <div class="col">
        <table class="table table-hover table_bordered">
          <thead>
            <tr>
              		<th>Id </th>
      				<th><spring:message code="persona.header.name"></spring:message></th>
      				<th><spring:message code="persona.header.motherSurname"></spring:message></th>
      				<th><spring:message code="persona.header.fatherSurname"></spring:message></th>
      				<th><spring:message code="persona.header.telephone"></spring:message> </th>
      				<th><spring:message code="persona.header.email"></spring:message> </th>
      				<th><spring:message code="persona.header.formation"></spring:message></th>
      				<th colspan="2"><spring:message code="persona.header.actions"></spring:message></th>
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
                <td> ${sessionScope['lang']=='es' ? persona.formacion.descripcionEsp : persona.formacion.descripcionEng} </td>
                <td> <a onclick="return confirmarBorrarPersona(${persona.id_persona})"><spring:message code="actions.delete"></spring:message></a> </td>
                <td> <a onclick="obtenerPersona(${persona.id_persona})"> <spring:message code="actions.edit"></spring:message></a> </td>
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
            <a id="linkNewPersona" class="nav-link" href=""><spring:message code="actions.newPerson"></spring:message></a>
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
