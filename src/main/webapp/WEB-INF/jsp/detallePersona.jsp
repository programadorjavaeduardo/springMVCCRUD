<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Recursos Humanos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventosPersona.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>
</head>
<body>

	<h1>${titulo}</h1>
	<form action="" name="form" id="form" method="post" onsubmit="return direccionar('${textoBoton}')">
    <label for="nombre">Nombre:</label>
    <br>
    <input type="text" name="nombre" id="nombre" value="${persona.nombre}">
    <br>
    <label for="ape_paterno">Apellido Paterno:</label>
    <br>
    <input type="text" name="ape_paterno" id="ape_paterno" value="${persona.ape_paterno}">
    <br>
    <label for="ape_materno">Apellido Materno:</label>
    <br>
    <input type="text" name="ape_materno" id="ape_materno" value="${persona.ape_materno}">
    <br>
    <label for="telefono">Telefono:</label>
    <br>
    <input type="text" name="telefono" id="telefono" value="${persona.telefono}">
    <br>
    <label for="email">Email:</label>
    <br>
    <input type="text" name="email" id="email" value="${persona.email}">
    <br>
    <label for="formacion">Formacion:</label>
    <select name="formacion" id="formacion">
      <option value="-1">Seleccione una de las opciones...</option>
      <c:forEach items="${formaciones}" var="formacion">
        <option value="${formacion.id_formacion}" ${formacion.id_formacion == formacionSeleccionada ? 'selected="selected"' : ''}>${formacion.descripcion}</option>
      </c:forEach>

    </select>
    <br/>
    <input type="submit" name="botonEnviar" value="${textoBoton}">
    <input type="button" id="botonCancelar" name="botonCancelar" value="Cancelar">
    <input type="hidden" name="id_persona" value="${persona.id_persona}">
  </form>
</body>
</html>
