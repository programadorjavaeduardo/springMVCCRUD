<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.detailAlumno"></spring:message></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosAlumno.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosAlumno.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var lang = "${sessionScope['lang']}"</script>

</head>
<body>
  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actions.jsp" ></jsp:include>
    <div class="row mt-5">
      <div class="col">
          <h3>${titulo}</h3>
      </div>
    </div>

    

  <div class="row">
    <div class="col">
      <form:form action="" name="form" id="form" method="post" onsubmit="return direccionarSalidaA(${Alumno.id_alumno})" commandName="Alumno">
      	
      	<form:errors path="*" cssStyle="color: #ff0000;" />
        <div class="form-group">
          <label for="nombre"><spring:message code="alumno.header.name"></spring:message></label>
          <form:input class="form-control" type="text" name="nombre" id="nombre" path="nombre"/>
          
        </div>

        <div class="form-group">
          <label for="ape_paterno"><spring:message code="alumno.header.fatherSurname"></spring:message></label>
          <form:input class="form-control" type="text" name="ape_paterno" id="ape_paterno" path="ape_paterno"/>
          
        </div>

        <div class="form-group">
          <label for="ape_materno"><spring:message code="alumno.header.motherSurname"></spring:message></label>
          <form:input class="form-control" type="text" name="ape_materno" id="ape_materno" path="ape_materno"/>
          
        </div>

        <div class="form-group">
          <label for="telefono"><spring:message code="alumno.header.telephone"></spring:message></label>
          <form:input class="form-control" type="text" name="telefono" id="telefono" path="telefono"/>
          
        </div>

        <div class="form-group">
          <label for="email"><spring:message code="alumno.header.email"></spring:message></label>
          <form:input class="form-control" type="text" name="email" id="email" path="email"/>
         
        </div>
        
        <div class="form-group">
          <label for="password"><spring:message code="alumno.header.password"></spring:message></label>
          <c:choose>
          	<c:when test="${Alumno.id_alumno==null}">
          		<form:input class="form-control" type="password" name="password" id="password" path="password"/>
          	</c:when>
          	<c:otherwise>
          		<form:input class="form-control" type="text" name="password" id="password" path="password"/>
          	</c:otherwise>
          </c:choose>
         
        </div>

        <div class="form-group">
          <label for="formacion"><spring:message code="alumno.header.formation"></spring:message></label>
          <form:select class="form-control" name="formacion" id="formacion" path="formacion.id_formacion">
            <form:option value="-1"><spring:message code="formation.select"></spring:message></form:option>
            <c:forEach items="${formaciones}" var="formacion">
              <option value="${formacion.id_formacion}" ${formacion.id_formacion == formacionSeleccionada ? 'selected="selected"' : ''}>${formacion.descripcionEsp}</option>
            </c:forEach>
          </form:select>
          
        </div>

        <div class="form-group">

            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" value="<spring:message code="actions.cancel"></spring:message>" class="btn btn-danger mr-4">

            <input type="hidden" name="id_alumno" value="${Alumno.id_alumno}">
            
        </div>
      </form:form>
    </div>
  </div>



  <jsp:include page="../common/footer.jsp" />
</div>


</body>
</html>
