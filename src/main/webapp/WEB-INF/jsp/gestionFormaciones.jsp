<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.formationManagement"></spring:message></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var mensajeConfirmacion="${mensajeConfirmacion}"</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
</head>
<body>
  <div class="container">
    <jsp:include page="../../common/header.jsp" />
    <div class="row mt-5">
      <div class="col">
          <h3> <spring:message code="title.formationManagement"></spring:message></h3>
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
      				<th><spring:message code="formation.header.formationDescEsp"></spring:message></th>
      				<th><spring:message code="formation.header.formationDescEng"></spring:message></th>
      				<th colspan="2"><spring:message code="persona.header.actions"></spring:message></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="formacion" items="${formaciones}">
              <tr>
                <td> ${formacion.id_formacion}</td>
                <td> ${formacion.descripcionEsp}</td>
                <td> ${formacion.descripcionEng}</td>
                <td> <a onclick="return confirmarBorrarFormacion(${formacion.id_formacion})"><spring:message code="actions.delete"></spring:message></a> </td>
                <td> <a onclick="obtenerFormacion(${formacion.id_formacion})"><spring:message code="actions.edit"></spring:message></a> </td>
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
            <a id="linkNewFormacion" class="nav-link" href=""><spring:message code="actions.newFormation"></spring:message></a>
          </li>
          <li class="nav-item">
            <a id="linkIndex" class="nav-link" href=""><spring:message code="actions.index"></spring:message></a>
          </li>
        </ul>

      </div>
    </div>
      <jsp:include page="../../common/footer.jsp" />
  </div>

</body>
</html>
