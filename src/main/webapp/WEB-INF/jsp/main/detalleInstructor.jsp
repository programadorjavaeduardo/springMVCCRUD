<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.detailInstructor"></spring:message></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>

<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>var lang = "${sessionScope['lang']}"</script>

</head>
<body>
  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actionsInstructor.jsp" ></jsp:include>
    <div class="row mt-5">
      <div class="col">
          <h3>${titulo}</h3>
      </div>
    </div>

    

  <div class="row">
    <div class="col">
      <form:form action="" name="form" id="form" method="post" onsubmit="return direccionarSalidaI(${instructor.id_instructor})" commandName="instructor">
      	
      	<form:errors path="*" cssStyle="color: #ff0000;" />
        <div class="form-group">
          <label for="nombre"><spring:message code="instructor.header.name"></spring:message></label>
          <form:input class="form-control" type="text" name="nombre" id="nombre" path="nombre"/>
          
        </div>

        <div class="form-group">
          <label for="ape_paterno"><spring:message code="instructor.header.fatherSurname"></spring:message></label>
          <form:input class="form-control" type="text" name="ape_paterno" id="ape_paterno" path="ape_paterno"/>
          
        </div>

        <div class="form-group">
          <label for="ape_materno"><spring:message code="instructor.header.motherSurname"></spring:message></label>
          <form:input class="form-control" type="text" name="ape_materno" id="ape_materno" path="ape_materno"/>
          
        </div>

        <div class="form-group">
          <label for="telefono"><spring:message code="instructor.header.telephone"></spring:message></label>
          <form:input class="form-control" type="text" name="telefono" id="telefono" path="telefono"/>
          
        </div>

        <div class="form-group">
          <label for="email"><spring:message code="instructor.header.email"></spring:message></label>
          <form:input class="form-control" type="text" name="email" id="email" path="email"/>
         
        </div>
        
        <div class="form-group">
          <label for="password"><spring:message code="instructor.header.password"></spring:message></label>
          <c:choose>
          	<c:when test="${instructor.id_instructor==null}">
          		<form:input class="form-control" type="password" name="password" id="password" path="password"/>
          	</c:when>
          	<c:otherwise>
          		<form:input class="form-control" type="text" name="password" id="password" path="password"/>
          	</c:otherwise>
          </c:choose>
         
        </div>

     
        <div class="form-group">

            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" onclick="history.back();" value="<spring:message code="actions.cancel"></spring:message>" class="btn btn-danger mr-4">

            <input type="hidden" name="id_instructor" value="${instructor.id_instructor}">
            
        </div>
      </form:form>
    </div>
  </div>



  <jsp:include page="../common/footer.jsp" />
</div>


</body>
</html>
