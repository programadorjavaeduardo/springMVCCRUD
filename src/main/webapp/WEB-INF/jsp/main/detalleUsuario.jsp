<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.detailFormation"></spring:message></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosFormacion.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosUsuario.js"></script>

<script>var lang = "${sessionScope['lang']}"</script>
<script>var ctx = "${pageContext.request.contextPath}"</script>


</head>
<body>
  <div class="container">
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/actions.jsp" ></jsp:include>
    <div class="row mt-5">
      <div class="col">
        <h1>${titulo}</h1>
      </div>
    </div>

    <div class="row">
      <div class="col">
        <form:form action="" name="form" id="form" method="post" onsubmit="return direccionarSalidaU('${usuario.id_usuario}')" commandName="usuario">
          <form:errors path="*" cssStyle="color: #ff0000;" />	
          <div class="form-group">
            <label for="username"><spring:message code="usuario.header.username"></spring:message></label>
            <form:input class="form-control" type="text" name="username" id="username" path="username"/>
           	
          </div>
          <div class="form-group">
            <label for="password"><spring:message code="usuario.header.password"></spring:message></label>
            <form:input class="form-control" type="text" name="password" id="password" path="password"/>
           	
          </div>
          <div class="form-group">
            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" value="<spring:message code="actions.cancel"></spring:message>" class="btn btn-danger mr-3">
            <input type="hidden" name="id_persona" value="${usuario.id_persona}">
            <input type="hidden" name="id_usuario" value="${usuario.id_usuario}">
          </div>
          
        </form:form>
      </div>
    </div>
    <jsp:include page="../common/footer.jsp" />
  </div>


</body>
</html>
