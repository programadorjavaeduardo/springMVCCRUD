<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>
  <div class="container">
    <jsp:include page="../../common/header.jsp" />
    <div class="row mt-5">
      <div class="col">
          <h3>${titulo}</h3>
      </div>
    </div>

    <div class="row">
      <div class="col">
          <form:errors path="*" cssStyle="color: #ff0000;"/>
      </div>
    </div>

  <div class="row">
    <div class="col">
      <form:form action="" name="form" id="form" method="post" onsubmit="return direccionar('${textoBoton}')" commandName="persona">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <form:input class="form-control" type="text" name="nombre" id="nombre" path="nombre"/>
          <form:errors path="nombre" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">
          <label for="ape_paterno">Apellido Paterno:</label>
          <form:input class="form-control" type="text" name="ape_paterno" id="ape_paterno" path="ape_paterno"/>
          <form:errors path="ape_paterno" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">
          <label for="ape_materno">Apellido Materno:</label>
          <form:input class="form-control" type="text" name="ape_materno" id="ape_materno" path="ape_materno"/>
          <form:errors path="ape_materno" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">
          <label for="telefono">Telefono:</label>
          <form:input class="form-control" type="text" name="telefono" id="telefono" path="telefono"/>
          <form:errors path="telefono" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">
          <label for="email">Email:</label>
          <form:input class="form-control" type="text" name="email" id="email" path="email"/>
          <form:errors path="email" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">
          <label for="formacion">Formacion:</label>
          <form:select class="form-control" name="formacion" id="formacion" path="formacion.id_formacion">
            <form:option value="-1">Seleccione una de las opciones...</form:option>
            <c:forEach items="${formaciones}" var="formacion">
              <option value="${formacion.id_formacion}" ${formacion.id_formacion == formacionSeleccionada ? 'selected="selected"' : ''}>${formacion.descripcion}</option>
            </c:forEach>
          </form:select>
          <form:errors path="formacion.id_formacion" cssStyle="color: #ff0000;"/>
        </div>

        <div class="form-group">

            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" value="Cancelar" class="btn btn-danger mr-4">

            <input type="hidden" name="id_persona" value="${persona.id_persona}">
        </div>
      </form:form>
    </div>
  </div>



  <jsp:include page="../../common/footer.jsp" />
</div>


</body>
</html>
