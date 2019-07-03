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
      <form action="" name="form" id="form" method="post" onsubmit="return direccionar('${textoBoton}')">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input class="form-control" type="text" name="nombre" id="nombre" value="${persona.nombre}">
        </div>

        <div class="form-group">
          <label for="ape_paterno">Apellido Paterno:</label>
          <input class="form-control" type="text" name="ape_paterno" id="ape_paterno" value="${persona.ape_paterno}">
        </div>

        <div class="form-group">
          <label for="ape_paterno">Apellido Paterno:</label>
          <input class="form-control" type="text" name="ape_paterno" id="ape_paterno" value="${persona.ape_paterno}">
        </div>

        <div class="form-group">
          <label for="ape_materno">Apellido Materno:</label>
          <input class="form-control" type="text" name="ape_materno" id="ape_materno" value="${persona.ape_materno}">
        </div>

        <div class="form-group">
          <label for="telefono">Telefono:</label>
          <input class="form-control" type="text" name="telefono" id="telefono" value="${persona.telefono}">
        </div>

        <div class="form-group">
          <label for="email">Email:</label>
          <input class="form-control" type="text" name="email" id="email" value="${persona.email}">
        </div>

        <div class="form-group">
          <label for="formacion">Formacion:</label>
          <select class="form-control" name="formacion" id="formacion">
            <option value="-1">Seleccione una de las opciones...</option>
            <c:forEach items="${formaciones}" var="formacion">
              <option value="${formacion.id_formacion}" ${formacion.id_formacion == formacionSeleccionada ? 'selected="selected"' : ''}>${formacion.descripcion}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-group">

            <input type="submit" name="botonEnviar" value="${textoBoton}" class="btn btn-primary mr-3">
            <input type="button" id="botonCancelar" name="botonCancelar" value="Cancelar" class="btn btn-danger mr-4">

            <input type="hidden" name="id_persona" value="${persona.id_persona}">
        </div>
      </form>
    </div>
  </div>




</div>


</body>
</html>
